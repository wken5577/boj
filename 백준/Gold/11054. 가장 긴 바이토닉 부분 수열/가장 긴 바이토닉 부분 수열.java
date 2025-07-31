import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] list = new int[n];
            for (int i = 0; i < n; i++) {
                list[i] = Integer.parseInt(input[i]);
            }
            Solution solution = new Solution();
            System.out.println(solution.solution(n, list));
        }
    }
}

class Solution {
    public int solution(int n, int[] list) {
        int[] inc = new int[n];
        int[] dec = new int[n];
        inc[0] = 1;
        dec[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (list[i] > list[j]) {
                    max = Math.max(max, inc[j]);
                }
            }
            inc[i] = max + 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            int max = 0;
            for (int j = i + 1; j < n; j++) {
                if (list[i] > list[j]) {
                    max = Math.max(max, dec[j]);
                }
            }
            dec[i] = max + 1;
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, inc[i] + dec[i] - 1);
        }
        return answer;
    }
}
