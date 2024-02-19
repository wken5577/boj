import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            String a = br.readLine();
            String b = br.readLine();

            int[][] dy = new int[a.length() + 1][b.length() + 1];

            int max = Integer.MIN_VALUE;

            for (int i = 1; i <= a.length(); i++) {
                for (int j = 1; j <= b.length(); j++) {
                    char chA = a.charAt(i - 1);
                    char chB = b.charAt(j - 1);
                    if (chA == chB) {
                            dy[i][j] = dy[i - 1][j - 1] + 1;
                    } else{
                        dy[i][j] = Math.max(dy[i - 1][j], dy[i][j - 1]);
                    }
                    if (dy[i][j] > max){
                        max = dy[i][j];
                    }
                }
            }

            System.out.println(max);
            if (max > 0)
                System.out.println(printLCS(dy, a.length(), b.length(), a));
        }
    }

    private static String printLCS(int[][] dy, int n, int m, String a) {
        StringBuilder sb = new StringBuilder();
        while (n > 0 && m > 0) {
            if (dy[n][m - 1] == dy[n][m])
                m--;
            else if (dy[n - 1][m] == dy[n][m])
                n--;
            else{
                sb.append(a.charAt(n - 1));
                n--;
                m--;
            }
        }
        return sb.reverse().toString();
    }
}