import java.io.*;
import java.util.*;

public class Main {
    static int n, k, r, cnt;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        int[][] map = new int[n + 1][n + 1];
        LinkedList<int[]>[][] lines = new LinkedList[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                lines[i][j] = new LinkedList<>();
            }
        }
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            lines[x][y].add(new int[] {x1, y1});
            lines[x1][y1].add(new int[] {x, y});
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
            queue.add(new int[]{x, y});
        }
        int sum = 0;
        while (!queue.isEmpty()){
            int[] now = queue.poll();
            boolean ch[][] = new boolean[n + 1][n + 1];
            ch[now[0]][now[1]] = true;
            cnt = 0;
            DFS(now,  map, ch, lines);
            sum += k - cnt - 1;
        }
        System.out.println(sum / 2);
    }

    private static void DFS(int[] now, int[][] map, boolean[][] ch, LinkedList<int[]>[][] lines) {
        for (int i = 0; i < 4; i++) {
            int nx = now[0] + dx[i];
            int ny = now[1] + dy[i];
            LinkedList<int[]> line = lines[now[0]][now[1]];
            if (1 <= nx && nx <= n && 1 <= ny && ny <= n && !ch[nx][ny]){
                boolean checkLine = false;
                for (int[] ints : line) {
                    if (ints[0] == nx && ints[1] == ny){
                        checkLine = true;
                        break;
                    }
                }
                if (checkLine)
                    continue;
                ch[nx][ny] = true;
                if (map[nx][ny] == 1)
                    cnt++;
                DFS(new int[]{nx, ny}, map, ch, lines);
            }
        }
    }

}
