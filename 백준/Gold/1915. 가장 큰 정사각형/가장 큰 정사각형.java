import java.io.*;
import java.util.*;


public class Main {
	static int n, m;
	static int[][] map, dy;

	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
		) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map = new int[n][m];
			dy = new int[n][m];

			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0; j < m; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}

			// dy 가로 첫행 초기화
			for (int i = 0; i < m; i++) {
				dy[0][i] = map[0][i];
			}

			// dy 새로 첫행 초기화
			for (int i = 0; i < n; i++) {
				dy[i][0] = map[i][0];
			}
			int answer = Integer.MIN_VALUE;
			for (int i = 1; i < n; i++) {
				for (int j = 1; j < m; j++) {
					if (map[i][j] == 1){
						if (dy[i - 1][j - 1] != 0){
							int tmp = checkBox(i, j, dy[i - 1][j - 1]);
							dy[i][j] = tmp + 1;
						}else{
							dy[i][j] = 1;
						}
					}
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					answer = Math.max(answer, dy[i][j] * dy[i][j]);
				}
			}
			System.out.println(answer);
		}
	}

	private static int checkBox(int x, int y, int size) {
		for (int i = 1; i <= size; i++) {
			if (map[x][y - i] == 0 || map[x - i][y] == 0)
				return i - 1;
		}
		return size;
	}

}

