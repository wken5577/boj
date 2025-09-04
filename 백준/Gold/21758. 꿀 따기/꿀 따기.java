import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] split = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(split[i]);
            }

            Solution solution = new Solution();
            solution.solution(n, arr);
        }
    }
}

class Solution {
    public void solution(int n, int[] arr) {
        int[] sum = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                sum[i] = arr[i];
            } else {
                sum[i] = sum[i - 1] + arr[i];
            }
        }

        int a = 0;
        // 벌 벌 꿀
        for (int i = 1; i < n - 1; i++) {
            int b1 = sum[n - 1] - sum[0] - arr[i];
            int b2 = sum[n - 1] - sum[i];
            a = Math.max(a, b1 + b2);
        }

        // 벌 꿀 벌
        int a2 = 0;
        for (int i = 1; i < n - 1; i++) {
            int b1 = sum[i] - arr[0];
            int b2 = sum[n - 2] - sum[i - 1];
            a2 = Math.max(a2, b1 + b2);
        }

        // 꿀 벌 벌
        int a3 = 0;
        for (int i = n - 2; i >= 1; i--) {
            int b1 = sum[n - 2] - arr[i];
            int b2 = sum[i - 1];
            a3 = Math.max(a3, b1 + b2);
        }

        System.out.println(Math.max(a, Math.max(a2, a3)));
    }

}

