import java.io.*;
import java.util.*;


public class Main {
	static int MOD = 1_000_000_000;

	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
		) {
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			int k = sc.nextInt();

			int[][] dy = new int[n + 1][k + 1];

			for (int j = 1; j <= k; j++) {
				dy[1][j] = j;
			}
			for (int i = 1; i <= n; i++) {
				dy[i][1] = 1;
			}

			for (int i = 2; i <= n; i++) {
				for (int j = 2; j <= k; j++) {
					dy[i][j] = (dy[i - 1][j] + dy[i][j - 1]) % MOD;
				}
			}
			System.out.println(dy[n][k]);
		}
	}


}

