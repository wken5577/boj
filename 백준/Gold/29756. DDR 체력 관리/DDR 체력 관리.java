import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int n, k;
	static int[][] dy;
	static int[] e, h;

	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
		) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			e = new int[n + 1];
			h = new int[n + 1];

			st = new StringTokenizer(br.readLine());
			dy =new int[n + 1][101];
			for (int i = 1; i <= n; i++) {
				e[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				h[i] = Integer.parseInt(st.nextToken());
			}

			System.out.println(solution(n, 100));
		}

	}

	private static int solution(int depth, int health){
		if (depth == 0)
			return 0;

		int nextHealth = Math.min(health + k, 100);

		if (dy[depth][nextHealth] != 0)
			return dy[depth][nextHealth];

		int res = solution(depth - 1, nextHealth);

		if (nextHealth - h[depth] >= 0){
			res = Math.max(res, solution(depth - 1, nextHealth - h[depth]) + e[depth]);
		}
		return dy[depth][nextHealth] = res;
	}

}