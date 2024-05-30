import java.io.*;
import java.util.*;


public class Main {
	static int n;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
		) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			StringTokenizer st;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 0 가로 1 세로 2 대각
			int[][][] dy = new int[n][n][3];
			for (int i = 1; i < n; i++) {
				if (map[0][i] == 0)
					dy[0][i][0] = 1;
				else
					break;
			}
			for (int i = 1; i < n; i++) {
				for (int j = 1; j < n; j++) {
					if (map[i][j] == 0){
						// 가로 파이프 처리
						dy[i][j][0] = dy[i][j - 1][0] + dy[i][j - 1][2];

						// 세로 파이프 처리
						dy[i][j][1] = dy[i - 1][j][1] + dy[i - 1][j][2];
					}

					// 대각선 처리
					if (map[i][j] == 0 && map[i - 1][j] == 0 && map[i][j - 1] == 0){
						dy[i][j][2] = dy[i - 1][j - 1][0] + dy[i - 1][j - 1][1] + dy[i - 1][j - 1][2];
					}

				}
			}

			int answer = 0;
			for(int s = 0; s < 3; s++){
				answer += dy[n - 1][n - 1][s];
			}
			System.out.println(answer);
		}
	}

}

