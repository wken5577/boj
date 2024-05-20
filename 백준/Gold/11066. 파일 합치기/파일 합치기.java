import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
		) {
			int t = Integer.parseInt(br.readLine());

			while (t-- > 0) {
				int n = Integer.parseInt(br.readLine());
				int[][] dy = new int[n + 1][n + 1];
				int[][] sum = new int[n + 1][n + 1];
				int[] arr = new int[n + 1];

				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int i = 1; i <= n; i++) {
					arr[i] = Integer.parseInt(st.nextToken());
				}

				// calc sum
				for (int i = 1; i <= n; i++) {
					sum[i][i] = arr[i];
					for (int j = i + 1; j <= n; j++) {
						sum[i][j] = sum[i][j - 1] + arr[j];
					}
				}

				// fill dy
				for (int k = 1; k < n; k++) {
					for (int i = 1; i < n; i++) {
						int j = i + k;
						if (j > n) continue;
						dy[i][j] = Integer.MAX_VALUE;
						for (int s = i; s <= j - 1; s++) {
							dy[i][j] = Math.min(dy[i][j], dy[i][s] + dy[s + 1][j] + sum[i][j]);
						}
					}
				}
				System.out.println(dy[1][n]);
			}

		}

	}

}

