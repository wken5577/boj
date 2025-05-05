import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] str = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int k = Integer.parseInt(str[1]);
            int[] coins = new int[n];

            for (int i = 0; i < n; i++) {
                coins[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(coins);
            System.out.println(new Solution().solution(n, k, coins));
        }
    }
}

class Solution {
    public int solution(int n, int k, int[] coins) {
        int[] dy = new int[k + 1];
        dy[0] = 1;
        for (int i = 0; i < n; i++) {
            int coin = coins[i];
            for (int j = coin; j <= k; j++) {
                dy[j] = dy[j] + dy[j - coin];
            }
        }

        return dy[k];
    }
}
