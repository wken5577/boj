import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		try (
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
		) {
			n = Integer.parseInt(br.readLine());
			map = new char[n][n];

			StringTokenizer st;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = st.nextToken().charAt(0);
				}
			}

			if (solution()) {
				System.out.println("YES");
				return;
			}
			System.out.println("NO");
		}
	}

	private static boolean solution() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 'X')
					map[i][j] = 'B';
				else continue;
				for (int a = 0; a < n; a++) {
					for (int b = 0; b < n; b++) {
						if (map[a][b] == 'X')
							map[a][b] = 'B';
						else continue;
						for (int c = 0; c < n; c++) {
							for (int d = 0; d < n; d++) {
								if (map[c][d] == 'X')
									map[c][d] = 'B';
								else continue;

								if (!moveTeacher()){
									return true;
								}
								map[c][d] = 'X';
							}

						}
						map[a][b] = 'X';
					}
				}
				map[i][j] = 'X';
			}
		}
		return false;
	}

	private static boolean moveTeacher() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 'T'){
					//위
					int next = i - 1;
					while (next >= 0){
						if (map[next][j] == 'B') break;
						if (map[next][j] == 'S') return true;
						next--;
					}

					//아래
					next = i + 1;
					while (next < n){
						if (map[next][j] == 'B') break;
						if (map[next][j] == 'S') return true;
						next++;
					}

					//오른쪽
					next = j + 1;
					while (next < n){
						if (map[i][next] == 'B') break;
						if (map[i][next]== 'S') return true;
						next++;
					}

					//왼쪽
					next = j - 1;
					while (next >= 0){
						if (map[i][next] == 'B') break;
						if (map[i][next]== 'S') return true;
						next--;
					}
				}
			}
		}

		return false;
	}

}

