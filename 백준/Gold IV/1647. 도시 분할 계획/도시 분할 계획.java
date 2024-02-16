
import java.io.*;
import java.util.*;
class Edge{
    int v1;
    int v2;
    int weight;
    public Edge(int v1, int v2, int weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }
}
public class Main {
    static int n, m;
    static int[] unf;
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            unf = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                unf[i] = i;
            }
            PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                pq.add(new Edge(a, b, c));
            }

            int answer = 0;
            int max = 0;
            while (!pq.isEmpty()){
                Edge cur = pq.poll();
                if (find(cur.v1) == find(cur.v2))
                    continue;
                union(cur.v1, cur.v2);
                answer += cur.weight;
                max = Math.max(max, cur.weight);
            }
            answer -= max;
            System.out.println(answer);
        }
    }

    public static void union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) unf[fa] = fb;
    }
    public static int find(int a) {
        if (unf[a] == a) return a;
        return unf[a] = find(unf[a]);
    }
}