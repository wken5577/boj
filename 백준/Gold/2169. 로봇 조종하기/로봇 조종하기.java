import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] dx = {0, -1, 0};
    static int[] dy = {1, 0, -1};
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

            int[][] dy = new int[n][m];
            dy[0][0] = map[0][0];
            for (int i = 1; i < m; i++) {
                dy[0][i] = dy[0][i - 1] + map[0][i];
            }

            for (int i = 1; i < n; i++) {
                // 왼쪽에서 오른쪽
                int[] tmp1 = new int[m];
                for (int j = 0; j < m; j++) {
                    // 위에서 내려온 값
                    int val = dy[i - 1][j] + map[i][j];
                    if (j == 0){
                        tmp1[j] = val;
                        continue;
                    }
                    int val2 = tmp1[j - 1] + map[i][j];
                    tmp1[j] = Math.max(val, val2);
                }

                // 오른쪽에서 왼쪽
                int[] tmp2 = new int[m];
                for (int j = m - 1; j >= 0; j--) {
                    // 위에서 내려온 값
                    int val = dy[i - 1][j] + map[i][j];
                    if (j == m - 1){
                        tmp2[j] = val;
                        continue;
                    }
                    // 오 -> 왼
                    int val2 = tmp2[j + 1] + map[i][j];
                    tmp2[j] = Math.max(val, val2);
                }
                for (int j = 0; j < m; j++) {
                    dy[i][j] = Math.max(tmp1[j], tmp2[j]);
                }

            }
            System.out.println(dy[n - 1][m - 1]);

        }
    }

}
