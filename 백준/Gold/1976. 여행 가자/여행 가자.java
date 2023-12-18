import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] unf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc = new Scanner(System.in);

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        unf = new int[n + 1];
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            unf[i] = i;
        }
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int res = Integer.parseInt(st.nextToken());
                if (res == 1) union(i, j);
            }
        }
        st = new StringTokenizer(br.readLine());
        int[] order = new int[m];
        for (int i = 0; i < m; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }
        if (m == 1){
            System.out.println("YES");
            return;
        }
        for (int i = 1; i < m; i++) {
            int fa = find(order[i]);
            int fb = find(order[i - 1]);
            if (fa != fb){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    static void union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) unf[fa] = fb;
    }

    static int find(int val){
        if (unf[val] == val) return val;
        return unf[val] = find(unf[val]);
    }
}
