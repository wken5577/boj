import java.io.*;
import java.util.*;

import javax.security.auth.login.AccountLockedException;

public class Main {
    static int n, m;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean ch;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            int[][] map = new int[n][m];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int time = 0;
            while (true){
                ch = false;
                // 바깥공기 채크
                int[][] airMap = new int[n][m];
                searchOutside(map, airMap, 0, 0, new boolean[n][m]);

                //치즈 녹이기
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (map[i][j] == 1)
                            deleteCheese(map, airMap,i, j);
                    }
                }
                time++;

                //check
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (map[i][j] == 1){
                            ch = true;
                            break;
                        }
                    }
                    if (ch)
                        break;
                }

                if (!ch)
                    break;
            }
            System.out.println(time);
        }
    }

    private static void deleteCheese(int[][] map, int[][] airMap, int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < n && 0 <= ny && ny < m && airMap[nx][ny] == 1) {
                cnt++;
            }
        }
        if (cnt >= 2)
            map[x][y] = 0;
    }

    private static void searchOutside(int[][] map, int[][] airMap, int x, int y, boolean[][] check) {
        airMap[x][y] = 1;
        check[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < n && 0 <= ny && ny < m && !check[nx][ny] && map[nx][ny] != 1) {
                searchOutside(map, airMap, nx, ny, check);
            }
        }
    }

}
