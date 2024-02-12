import java.io.*;
import java.util.*;


public class Main {

    final static long MOD = 1_000_000_007L;
    final static long[][] A = new long[][]{{1, 1}, {1, 0}};


    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            long n = Long.parseLong(br.readLine());
            long[][] origin = new long[][]{{1, 1}, {1, 0}};
            System.out.println(calc(origin, n - 1)[0][0]);

        }

    }

    private static long[][] calc(long[][] origin, long exp) {
        if(exp == 1 || exp == 0)
            return origin;

        long[][] ret = calc(origin, exp / 2);
        ret = multiply(ret, ret);

        if (exp % 2 != 0)
            ret = multiply(ret, A);
        return ret;
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