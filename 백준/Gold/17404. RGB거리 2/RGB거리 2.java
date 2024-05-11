import java.io.*;
import java.util.*;

public class Main {
	static int R = 0, G = 1, B = 2;

	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
		) {

			int n = Integer.parseInt(br.readLine());
			int[][][] dy = new int[n + 1][3][3];
			int[][] data = new int[n + 1][3];
			for (int i = 1; i <= n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				data[i][R] = Integer.parseInt(st.nextToken());
				data[i][G] = Integer.parseInt(st.nextToken());
				data[i][B] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i <= n; i++) {
				for (int j = 0; j < 3; j++) {
					for (int k = 0; k < 3; k++) {
						dy[i][j][k] = Integer.MAX_VALUE;
					}
				}
			}

			dy[1][R][R] = data[1][R];
			dy[1][G][G] = data[1][G];
			dy[1][B][B] = data[1][B];

			// 2번줄 완성
			dy[2][R][G] = data[2][R] + dy[1][G][G];
			dy[2][R][B] = data[2][R] + dy[1][B][B];

			dy[2][G][R] = data[2][G] + dy[1][R][R];
			dy[2][G][B] = data[2][G] + dy[1][B][B];

			dy[2][B][G] = data[2][B] + dy[1][G][G];
			dy[2][B][R] = data[2][B] + dy[1][R][R];

			for (int i = 3; i <= n; i++) {
				dy[i][R][G] = data[i][R] + Math.min(Math.min(dy[i - 1][G][G], dy[i - 1][G][G]), Math.min(dy[i - 1][B][G], dy[i - 1][B][G]));
				dy[i][R][B] = data[i][R] + Math.min(Math.min(dy[i - 1][G][B], dy[i - 1][G][B]), Math.min(dy[i - 1][B][B], dy[i - 1][B][B]));

				dy[i][G][R] = data[i][G] + Math.min(Math.min(dy[i - 1][R][R], dy[i - 1][R][R]), Math.min(dy[i - 1][B][R], dy[i - 1][B][R]));
				dy[i][G][B] = data[i][G] + Math.min(Math.min(dy[i - 1][R][B], dy[i - 1][R][B]), Math.min(dy[i - 1][B][B], dy[i - 1][B][B]));

				dy[i][B][R] = data[i][B] + Math.min(Math.min(dy[i - 1][G][R], dy[i - 1][G][R]), Math.min(dy[i - 1][R][R], dy[i - 1][R][R]));
				dy[i][B][G] = data[i][B] + Math.min(Math.min(dy[i - 1][G][G], dy[i - 1][G][G]), Math.min(dy[i - 1][R][G], dy[i - 1][R][G]));

				if (i != n){
					dy[i][R][R] = data[i][R] + Math.min(Math.min(dy[i - 1][G][R], dy[i - 1][G][R]), Math.min(dy[i - 1][B][R], dy[i - 1][B][R]));
					dy[i][G][G] = data[i][G] + Math.min(Math.min(dy[i - 1][R][G], dy[i - 1][R][G]), Math.min(dy[i - 1][B][G], dy[i - 1][B][G]));
					dy[i][B][B] = data[i][B] +Math.min(Math.min(dy[i - 1][G][B], dy[i - 1][G][B]), Math.min(dy[i - 1][R][B], dy[i - 1][R][B]));
				}


			}

			int answer = Integer.MAX_VALUE;
			for (int i = 0; i < 3; i++) {
				answer = Math.min(answer, dy[n][R][i]);
				answer = Math.min(answer, dy[n][G][i]);
				answer = Math.min(answer, dy[n][B][i]);
			}
			System.out.println(answer);
		}

	}

}

