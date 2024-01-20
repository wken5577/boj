import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean ch;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer st;
            n = Integer.parseInt(br.readLine());
            boolean[][] map = new boolean[101][101];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                int g = Integer.parseInt(st.nextToken());

                List<int[]> points = new ArrayList<>();
                int[] gen0Start = new int[] {x, y};
                int[] gen0End = new int[]{x + dx[d], y + dy[d]};
                points.add(gen0Start);
                points.add(gen0End);
                map[gen0Start[1]][gen0Start[0]] = true;
                map[gen0End[1]][gen0End[0]] = true;
                dragonCurve(points, g, map);
            }
            System.out.println(countAnswer(map));
        }
    }

    private static int countAnswer(boolean[][] map) {
        int cnt = 0;
        int[] nextX = {0, 0, 1, 1};
        int[] nextY = {0, 1, 1, 0};
        for (int i = 0; i <= 99; i++) {
            for (int j = 0; j <= 99; j++) {
                int check = 0;
                for (int d = 0; d < 4; d++) {
                    int nx = i + nextX[d];
                    int ny = j + nextY[d];
                    if (map[nx][ny])
                        check++;
                }
                if (check == 4)
                    cnt++;
            }
        }


        return cnt;
    }

    private static void dragonCurve(List<int[]> points, int g, boolean[][] map) {
        for (int i = 0; i < g; i++) {
            int size = points.size();
            int [] prev = points.get(size - 1);
            for (int j = size - 1; j > 0; j--) {
                int[] target = points.get(j);
                int[] now = points.get(j - 1);
                int tmp = Math.abs(now[0] - target[0]);
                int disX = (now[0] >= target[0]) ? -tmp : tmp;
                tmp = Math.abs(now[1] - target[1]);
                int disY = (now[1] >= target[1]) ? -tmp : tmp;
                int next[] = new int[] {prev[0] + disY, prev[1] + -1 * disX};
                points.add(next);
                prev = next;
                map[next[1]][next[0]] = true;
            }
        }
    }

}
