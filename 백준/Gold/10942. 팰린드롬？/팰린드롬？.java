import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static boolean[][] dy;

	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
		) {
			n = Integer.parseInt(br.readLine());
			int[] arr = new int[n + 1];
			dy = new boolean[n + 1][n + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			m = Integer.parseInt(br.readLine());
			solution(arr);
			while (m-- > 0) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				bw.write(dy[s][e] ? "1\n" : "0\n");
			}
		}

	}

	private static void solution(int[] arr) {
		for (int i = 1; i <= n; i++) {
			dy[i][i] = true;
		}
		for (int i = 1; i <= n - 1; i++) {
			if (arr[i] == arr[i + 1])
				dy[i][i + 1] = true;
		}

		for(int i = 2; i <= n; i++){
			int s = 1;
			int e = s + i;
			while (e <= n){
				if (arr[s] == arr[e] && dy[s + 1][e - 1])
					dy[s][e] = true;
				s++; e++;
			}
		}
	}

}