import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static char[][] map;
	static List<int[]> empties = new ArrayList<>();

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
					if (map[i][j] == 'X')
						empties.add(new int[] {i, j});
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
		return combine(0, 0);
	}

	private static boolean combine(int s, int l) {
		if (l == 3){
			if (!moveTeacher())
				return true;
			return false;
		}

		for (int i = s; i < empties.size(); i++) {
			int[] point = empties.get(i);
			map[point[0]][point[1]] = 'B';
			if (combine(i + 1, l + 1))
				return true;
			map[point[0]][point[1]] = 'X';
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

