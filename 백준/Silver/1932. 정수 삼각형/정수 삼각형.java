import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map, dy;
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            dy = new int[n][n];
            StringTokenizer st;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j <= i; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dy[0][0] = map[0][0];
            for (int i = 1; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    if (j == 0){
                        dy[i][j] = dy[i - 1][j] + map[i][j];
                    }else if (i == j){
                        dy[i][j] = dy[i - 1][j - 1] + map[i][j];
                    }else{
                        dy[i][j] = Math.max(dy[i - 1][j], dy[i - 1][j - 1]) + map[i][j];
                    }
                }
            }
            int answer = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                answer = Math.max(answer, dy[n - 1][i]);
            }
            System.out.println(answer);
        }
    }


}