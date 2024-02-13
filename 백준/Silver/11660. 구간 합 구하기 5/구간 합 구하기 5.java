
import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            int[][] map = new int[n][n];
            int[][] dy = new int[n][n];
            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int x1 = Integer.parseInt(st.nextToken()) - 1;
                int y1 = Integer.parseInt(st.nextToken()) - 1;
                int x2 = Integer.parseInt(st.nextToken()) - 1;
                int y2 = Integer.parseInt(st.nextToken()) - 1;
                list.add(new int[]{x1, y1, x2, y2});
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (j == 0)
                        dy[i][j] = map[i][j];
                    else
                        dy[i][j] = map[i][j] + dy[i][j - 1];
                }
            }

            for (int[] data : list) {
                int x1 = data[0];
                int y1 = data[1];
                int x2 = data[2];
                int y2 = data[3];
                int res = 0;
                for (int i = x1; i <= x2; i++) {
                    int tmp;
                    if (y1 != 0)
                        tmp = dy[i][y2] - dy[i][y1 - 1];
                    else
                        tmp = dy[i][y2];
                    res += tmp;
                }
                bw.write(res + "\n");
            }
        }
    }
}