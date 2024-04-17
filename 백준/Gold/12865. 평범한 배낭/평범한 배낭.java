import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, k;
        n = sc.nextInt();
        k = sc.nextInt();
        int[] dy = new int[k + 1];
        for (int i = 0; i < n; i++) {
            int w = sc.nextInt();
            int v = sc.nextInt();
            for (int j = k; j >= w; j--) {
                if (j - w >= 0) {
                    dy[j] = Math.max(dy[j - w] + v, dy[j]);
                }
            }
        }
        System.out.println(dy[k]);

    }
}
