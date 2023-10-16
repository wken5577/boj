import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[][] dy = new int[n + 5][4];
            dy[1][1] = 1;
            dy[2][1] = 1;
            dy[2][2] = 1;
            dy[3][1] = 1;
            dy[3][2] = 1;
            dy[3][3] = 1;

            for (int j = 4; j <= n; j++) {
                dy[j][1] = dy[j - 1][1];
                dy[j][2] = dy[j - 2][1] + dy[j - 2][2];
                dy[j][3] = dy[j - 3][1] + dy[j - 3][2] + dy[j - 3][3];
            }
            System.out.println(dy[n][1] + dy[n][2] + dy[n][3]);
        }

    }
}

