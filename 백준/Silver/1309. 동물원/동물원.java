import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(new Solution().solution(n));
        br.close();
    }
}

class Solution {

    static final int MOD = 9901;

    public int solution(int n) {
        int[][] dy = new int[n + 1][3];
        dy[1][0] = 1;
        dy[1][1] = 1;
        dy[1][2] = 1;

        for (int i = 2; i <= n; i++) {
            dy[i][0] = (dy[i - 1][0] % MOD) + (dy[i - 1][1] % MOD) + (dy[i - 1][2] % MOD);
            dy[i][1] = (dy[i - 1][0] % MOD) + (dy[i - 1][2] % MOD);
            dy[i][2] = (dy[i - 1][0] % MOD) + (dy[i - 1][1] % MOD);
        }

        return (dy[n][0] + dy[n][1] + dy[n][2]) % MOD;
    }
}

