import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] dy;

	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
		) {
			n = Integer.parseInt(br.readLine());
			List<int[]> list = new ArrayList<>();
			StringTokenizer st;
			list.add(new int[]{});
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				list.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
			}
			dy = new int[n + 1][n + 1];
			solution(list);
			bw.write(dy[1][n] + "\n");
		}

	}

	private static void solution(List<int[]> list) {
		for (int i = 1; i < n; i++) {
			int[] matrix1 = list.get(i);
			int[] matrix2 = list.get(i + 1);
			dy[i][i + 1] = matrix1[0] * matrix1[1] * matrix2[1];
		}

		for (int i = 2; i <= n; i++) {
			int s = 1;
			int e = s + i;

			while (e <= n) {
				dy[s][e] = Integer.MAX_VALUE;
				for (int mid = s; mid < e; mid++) {
					int n = list.get(s)[0];
					int m = list.get(mid)[1];
					int k = list.get(e)[1];
					dy[s][e] = Math.min(dy[s][e], dy[s][mid] + dy[mid + 1][e] + n * m * k);
				}
				s++; e++;
			}

		}
	}

}