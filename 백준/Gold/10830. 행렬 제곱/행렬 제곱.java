import java.io.*;
import java.util.*;


public class Main {

    final static long MOD = 1_000L;
    static long[][] origin;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long e = Long.parseLong(st.nextToken());
            long[][] matrix = new long[n][n];
            origin = new long[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken()) % MOD;
                    origin[i][j] = matrix[i][j];
                }
            }
            long[][] res = pow(matrix, e);
            for (long[] re : res) {
                for (long l : re) {
                    System.out.print(l + " ");
                }
                System.out.println();
            }
        }

    }

    private static long[][] pow(long[][] matrix, long e) {
        if (e == 1)
            return matrix;

        long[][] res = pow(matrix, e / 2);
        res = multiply(res, res);

        if (e % 2 != 0)
            res = multiply(res, origin);
        return res;
    }


    private static long[][] multiply(long[][] a, long[][] b) {
        long[][] ret = new long[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < b.length; k++) {
                    ret[i][j] += a[i][k] * b[k][j];
                    ret[i][j] %= MOD;
                }
            }
        }
        return ret;
    }


}