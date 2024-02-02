import java.io.*;
import java.util.*;

public class Main {
    static int n, m, w;
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer st;
            n = Integer.parseInt(br.readLine());
            m = Integer.parseInt(br.readLine());
            int[][] list = new int[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                Arrays.fill(list[i], -1);
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                if (list[s][e] != -1)
                    list[s][e] = Math.min(list[s][e], t);
                else
                    list[s][e] = t;
            }

            for (int d = 1; d <= n; d++) {
                for (int s = 1; s <= n; s++) {
                    for (int e = 1; e <= n; e++) {
                        if (s == e) {
                            list[s][e] = 0;
                            continue;
                        }
                        if (list[s][d] == -1 || list[d][e] == -1) continue;
                        if (list[s][e] == -1)
                            list[s][e] = list[s][d] + list[d][e];
                        else
                            list[s][e] = Math.min(list[s][e], list[s][d] + list[d][e]);
                    }
                }
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    int res = list[i][j] == -1 ? 0 : list[i][j];
                    bw.write(res + " ");
                }
                bw.write("\n");
            }
        }
    }

}
