import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class Main {
	static int n, m;

	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
		) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			int[] memory = new int[n + 1];
			int[] cost = new int[n + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				memory[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			int sum = 0;
			for (int i = 1; i <= n; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
				sum += cost[i];
			}
			int[][] dy = new int[n + 1][sum + 1];
			for (int i = 1; i <= n; i++) {
				for (int j = 0; j <= sum; j++) {
					if (j - cost[i] >= 0){
						dy[i][j] = Math.max(dy[i][j], dy[i - 1][j - cost[i]] + memory[i]);
					}
					dy[i][j] = Math.max(dy[i - 1][j], dy[i][j]);

				}
			}

			for (int j = 0; j <= sum; j++) {
				for (int i = 1; i <= n; i++) {
					if (dy[i][j] >= m){
						System.out.println(j);
						return;
					}
				}
			}
		}

	}

}