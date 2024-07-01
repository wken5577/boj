import java.io.*;
import java.util.*;

public class Main {
	static boolean[][] dy;
	static int n, w;
	static int[] weights, arr;
	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
		) {
			 n = Integer.parseInt(br.readLine());
			arr = new int[n + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			dy = new boolean[n + 1][40_001];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			 w = Integer.parseInt(br.readLine());
			weights = new int[w];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < w; i++) {
				weights[i] = Integer.parseInt(st.nextToken());
			}

			solution(0, 0);

			for (int i = 0; i < w; i++) {
				int target = weights[i];
				boolean ch = false;
				for (int j = 0; j <= n; j++) {
					if (dy[j][target]){
						ch = true;
						System.out.print("Y ");
						break;
					}
				}
				if(!ch)
					System.out.print("N ");
			}
		}
	}

	private static void solution(int i, int weight) {
		if (i > n || dy[i][weight]) return;

		dy[i][weight] = true;

		solution(i + 1, weight + arr[i]);
		solution(i + 1, weight);
		solution(i + 1, Math.abs(weight - arr[i]));
	}

}