import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] colors = new int[n][3];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            colors[i][0] = Integer.parseInt(input[0]);
            colors[i][1] = Integer.parseInt(input[1]);
            colors[i][2] = Integer.parseInt(input[2]);
        }

        System.out.println(new Solution().solution(n, colors));
        br.close();
    }
}

class Solution {

    public int solution(int n, int[][] colors) {
        int[][] dy = new int[n][3];
        dy[0][0] = colors[0][0];
        dy[0][1] = colors[0][1];
        dy[0][2] = colors[0][2];

        for (int i = 1; i < n; i++) {
            int red = colors[i][0];
            int green = colors[i][1];
            int blue = colors[i][2];

            dy[i][0] = Math.min(dy[i - 1][1], dy[i - 1][2]) + red;
            dy[i][1] = Math.min(dy[i - 1][0], dy[i - 1][2]) + green;
            dy[i][2] = Math.min(dy[i - 1][0], dy[i - 1][1]) + blue;
        }

        return Math.min(dy[n - 1][0], Math.min(dy[n - 1][1], dy[n - 1][2]));
    }
}