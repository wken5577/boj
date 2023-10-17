import java.io.*;
import java.util.*;

class Main {
    static int n, m, x;
    static List<List<int[]>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());
        x = Integer.valueOf(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.valueOf(st.nextToken());
            int end = Integer.valueOf(st.nextToken());
            int val = Integer.valueOf(st.nextToken());
            list.get(start).add(new int[]{end, val});
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int ret = search(i);
            answer = Math.max(answer, ret);
        }
        System.out.println(answer);

    }

    private static int search(int i) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        queue.add(new int[]{i, 0, 0});

        int[] djGo = new int[n + 1];
        int[] djBack = new int[n + 1];
        Arrays.fill(djGo, Integer.MAX_VALUE);
        Arrays.fill(djBack, Integer.MAX_VALUE);

        int ret = Integer.MAX_VALUE;
        if (i == x)
            return 0;
        while (!queue.isEmpty()){
            int[] now = queue.poll();
            if (now[0] == x)
                now[2] = 1;

            if (now[0] == i && now[2] == 1)
                ret = Math.min(ret, now[1]);
            for (int[] next : list.get(now[0])) {
                if (now[2] != 1 && next[0] == i)
                    continue;
                if (now[2] == 0 && djGo[next[0]] > now[1] + next[1]){
                    djGo[next[0]] = now[1] + next[1];
                    queue.add(new int[]{next[0], next[1] + now[1], now[2]});
                }else if (now[2] == 1 && djBack[next[0]] > now[1] + next[1]) {
                    djBack[next[0]] = now[1] + next[1];
                    queue.add(new int[]{next[0], next[1] + now[1], now[2]});
                }
            }
        }
        return ret;
    }
}