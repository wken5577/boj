
import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] pm;
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            pm =  new int[m];
            DFS(0, 1);
        }
    }

    private static void DFS(int L, int S) {
        if (L == m){
            for (int num : pm) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = S; i <= n; i++) {
            pm[L] = i;
            DFS(L + 1, i + 1);
        }
    }
}