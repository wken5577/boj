import java.io.*;
import java.util.*;

import static java.lang.System.exit;

public class Main {
    static int n, m;
    static int[] d;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = new int[n + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[0] = 0;
        List<List<int[]>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(s).add(new int[]{e, c});
            list.get(e).add(new int[]{s, c});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.add(new int[]{1, 0});
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            for(int[] next : list.get(now[0])){
                int nextCost = now[1] + next[1];
                if (d[next[0]] > nextCost){
                    pq.add(new int[]{next[0], nextCost});
                    d[next[0]] = nextCost;
                }
            }
        }
        System.out.println(d[n]);

    }
}
