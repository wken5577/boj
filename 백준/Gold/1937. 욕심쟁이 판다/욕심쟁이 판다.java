import java.io.*;
import java.util.*;


public class Main {
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int max = 0, answer = 0, tmp = 0;

	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
		) {
			int n = Integer.parseInt(br.readLine());
			int[][] dp = new int[n][n];
			int[][] arr = new int[n][n];
			StringTokenizer st;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			solution(dp, arr, n);
			System.out.println(answer);
		}

	}

	private static void solution(int[][] dp, int[][] arr, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				answer = Math.max(answer, searchMap(arr, i, j, n, dp));
			}
		}
	}

	private static int searchMap(int[][] arr, int i, int j, int n,int[][] dp) {
		if (dp[i][j] != 0) return dp[i][j];
		dp[i][j] = 1;
		for (int d = 0; d < 4; d++) {
			int nx = i + dx[d];
			int ny = j + dy[d];
			if (0 <= nx && nx < n && 0 <= ny && ny < n && arr[nx][ny] > arr[i][j] && dp[nx][ny] != -1) {
				dp[i][j] = Math.max(searchMap(arr, nx, ny, n, dp) + 1, dp[i][j]);
			}
		}
		return dp[i][j];
	}

}

