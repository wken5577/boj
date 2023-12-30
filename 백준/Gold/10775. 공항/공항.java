import java.io.*;
import java.util.*;

public class Main {
    static int n, k, g, p;
    static int unf[];
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            g = Integer.parseInt(br.readLine());
            p = Integer.parseInt(br.readLine());
            int plane[] = new int[p + 1];
            unf = new int[g + 1];
            for(int i = 1; i <= p; i++) {
                plane[i] = Integer.parseInt(br.readLine());
            }
            for (int i = 1; i <= g; i++) {
                unf[i] = i;
            }
            int cnt = 0;
            for (int i = 1; i <= p; i++) {
                int docking = find(plane[i]);
                if(docking == 0)
                    break;
                cnt++;
                union(docking, docking - 1);
            }
            System.out.println(cnt);
        }

    }
    public static void union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) unf[fa] = fb;
    }

    public static int find(int num) {
        if (unf[num] == num) return num;
        return unf[num] = find(unf[num]);
    }
}
