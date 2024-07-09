import java.io.*;
import java.util.*;

public class Main {
	static int n, r, c;
	static int[][] map;
	static int[] dx = {0, -1, 1, 0};
	static int[] dy = {1, 0, 0, -1};
	static int EMPTY = -1;

	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
		) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			map = new int[r][c];
			for (int i = 0; i < r; i++) {
				String str = br.readLine();
				for (int j = 0; j < c; j++) {
					char ch = str.charAt(j);
					if (ch == '.')
						map[i][j] = EMPTY;
					else
						map[i][j] = 0;
				}
			}
			int cnt = 1;
			while (cnt <= n){
				if (cnt == 1){
					cnt++;
					continue;
				}
				if (cnt % 2 == 0)
					bombInstallation(cnt);
				else
					boobStart(cnt);
				cnt++;
			}
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (map[i][j] == EMPTY)
						bw.write(".");
					else
						bw.write("O");
				}
				bw.write("\n");
			}
		}
	}

	private static void boobStart(int cnt) {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (cnt - map[i][j] == 3) {
					for (int d = 0; d < 4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						if (0 <= nx && nx < r && 0 <= ny && ny < c && map[nx][ny] != map[i][j])
							map[nx][ny] = EMPTY;
					}
					map[i][j] = EMPTY;
				}
			}
		}
	}

	private static void bombInstallation(int cnt) {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] == EMPTY) {
					map[i][j] = cnt;
				}
			}
		}
	}

}
