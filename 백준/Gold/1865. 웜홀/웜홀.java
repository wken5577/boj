import java.io.*;
import java.util.*;
class Edge {
    int from;    int to;    int time;
    Edge(int from, int to, int time) {
        this.from = from;
        this.to = to;
        this.time = time;
    }
}


public class Main {
    static int n, m, w;
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int tc = Integer.parseInt(st.nextToken());

            for (int i = 0; i < tc; i++) {
                st = new StringTokenizer(br.readLine());
                n = Integer.parseInt(st.nextToken());
                m = Integer.parseInt(st.nextToken());
                w = Integer.parseInt(st.nextToken());

                ArrayList<Edge> edges = new ArrayList<>();


                for (int j = 0; j < m + w; j++) {
                    st = new StringTokenizer(br.readLine());
                    int s = Integer.parseInt(st.nextToken());
                    int e = Integer.parseInt(st.nextToken());
                    int v = Integer.parseInt(st.nextToken());
                    if (j >= m){
                        edges.add(new Edge(s, e, -v));
                    }else{
                        edges.add(new Edge(s, e, v));
                        edges.add(new Edge(e, s, v));
                    }
                }

                boolean cycle = false;
                for (int j = 1; j <= n; j++) {
                    cycle = bellman_ford( j, edges);
                    if (cycle){
                        break;
                    }
                }
                System.out.println(cycle ? "YES" : "NO");
            }

        }
    }

    private static boolean bellman_ford(int start, ArrayList<Edge> edges) {
        int[] dis = new int[n + 1];
        Arrays.fill(dis, INF);
        dis[start] = 0;
        boolean update;

        for (int i = 1; i <= n; i++) {
            update = false;
            for (int j = 0; j < edges.size(); j++) {
                Edge cur = edges.get(j);
                if (dis[cur.from] != INF && dis[cur.to] > dis[cur.from] + cur.time) {
                    dis[cur.to] = dis[cur.from] + cur.time;
                    update = true;
                    if (i == n) {
                        return true;
                    }
                }

            }
            if (!update)
                break;
        }

        return false;
    }
}
