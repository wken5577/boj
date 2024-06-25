import java.io.*;
import java.util.*;

public class Main {
	static int[] nums;
	static int n;
	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
		) {
			n = Integer.parseInt(br.readLine());
			nums = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}

			long[][] dy = new long[n][21];
			dy[0][nums[0]] = 1;

			for (int i = 1; i < n - 1; i++) {
				for (int j = 0; j <= 20; j++) {
					if (j + nums[i] <= 20 && dy[i - 1][j] != 0){
						dy[i][j + nums[i]] += dy[i - 1][j];
					}

					if (j - nums[i] >= 0 && dy[i - 1][j] != 0){
						dy[i][j - nums[i]] += dy[i - 1][j];
					}
				}
			}

			System.out.println(dy[n - 2][nums[n - 1]]);

		}
	}

}

