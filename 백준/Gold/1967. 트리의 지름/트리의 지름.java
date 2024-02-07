import java.io.*;
import java.util.*;

public class Main {
    static int n, m, w;
    static List<int[]>[] map;
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            n = Integer.parseInt(br.readLine());
            map = new List[n + 1];
            for (int i = 1; i <= n; i++) {
                map[i] = new ArrayList<>();
            }

            StringTokenizer st;
            for (int i = 0; i < n - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int s1 = Integer.parseInt(st.nextToken());
                int s2 = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                map[s1].add(new int[] {s2, v});
                map[s2].add(new int[] {s1, v});
            }
            if(n == 1){
                System.out.println(0);
                return;
            }

            int[] tmp = searchMax(1);
            int[] max = searchMax(tmp[0]);
            System.out.println(max[1]);
        }
    }

    private static int[] searchMax(int start) {
        int[] res = new int[2];
        int max = 0;
        boolean[] ch = new boolean[n + 1];
        ch[start] = true;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        pq.add(new int[] {start, 0});

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int now = poll[0];
            int cost = poll[1];

            if (cost > max){
                res[0] = now;
                max = cost;
                res[1] = max;
            }

            List<int[]> nexts = map[now];
            for (int[] next : nexts) {
                if (!ch[next[0]]){
                    ch[next[0]] = true;
                    pq.add(new int[] {next[0], next[1] + cost});
                }
            }

        }

        return res;
    }

}
