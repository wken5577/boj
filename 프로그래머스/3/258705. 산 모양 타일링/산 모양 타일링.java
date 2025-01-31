class Solution {
    public int solution(int n, int[] tops) {
        int[] dp1 = new int[n];  // 3 으로만
        int[] dp2 = new int[n];  // 1, 2, 4 로만
        int mod = 10007;

        if (tops[0] == 1) {
            dp1[0] = 1;
            dp2[0] = 3;
        } else {
            dp1[0] = 1;
            dp2[0] = 2;
        }

        for (int i = 1; i < n; i++) {
            dp1[i] = (dp1[i - 1] + dp2[i - 1]) % mod;

            if (tops[i] == 1) {
                dp2[i] = (dp1[i - 1] * 2 + dp2[i - 1] * 3) % mod;
            } else {
                dp2[i] = (dp1[i - 1] + dp2[i - 1] * 2) % mod;
            }
        }


        return (dp1[n - 1] + dp2[n - 1]) % mod;
    }
}
