import java.io.*;
import java.util.*;

public class Main {
    static int v;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer st;
            v = Integer.parseInt(br.readLine());
            List<List<int[]>> list = new ArrayList<>();
            for (int i = 0; i <= v; i++) {
                list.add(new ArrayList<>());
            }

            for (int i = 0; i < v; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                List<int[]> integerList = list.get(s);
                while (true){
                    int e = Integer.parseInt(st.nextToken());
                    if (e == -1)
                        break;
                    int d = Integer.parseInt(st.nextToken());
                    integerList.add(new int[] {e, d});
                }
            }
            int[] max = searchMax(list, 1);
            int[] difMax = searchMax(list, max[0]);
            System.out.println(difMax[1]);
        }
    }

    private static int[] searchMax(List<List<int[]>> list, int s) {
        int max = Integer.MIN_VALUE;
        int node = -1;
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        queue.add(new int[] {s, 0});
        boolean[] visit = new boolean[v + 1];
        visit[s] = true;

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            if (max < now[1]){
                node = now[0];
                max = now[1];
            }
            List<int[]> nexts = list.get(now[0]);
            for (int[] next : nexts) {
                if (!visit[next[0]]){
                    visit[next[0]] = true;
                    queue.add(new int[] {next[0], now[1] + next[1]});
                }
            }
        }

        return new int[]{node, max};
    }

}
