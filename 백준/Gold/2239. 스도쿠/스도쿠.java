import static java.lang.System.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map = new int[9][9];

	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
		) {
			for (int i = 0; i < 9; i++) {
				String tmp = br.readLine();
				for (int j = 0; j < 9; j++) {
					map[i][j] = tmp.charAt(j) - '0';
				}
			}
			solution(next());
		}

	}

	private static void solution(int[] now) {
		if (now == null){
			printMap();
			exit(0);
		}
		for (int i = 1; i <= 9; i++) {
			int x = now[0];
			int y = now[1];
			map[x][y] = i;
			int[] nowArea = getAreaStartPoint(x, y);
			if (validateRow(y) && validateColumn(x) && validateArea(nowArea[0], nowArea[1])) {
				solution(next());
			}
			map[x][y] = 0;
		}
	}

	private static int[] next(){
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (map[i][j] == 0)
					return new int[] {i, j};
			}
		}
		return null;
	}

	private static void printMap() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static int[] getAreaStartPoint(int x, int y){
		if (0 <= x && x <= 2 && 0 <= y && y <= 2)
			return new int[] {0, 0};
		else if (0 <= x && x <= 2 && 3 <= y && y <= 5)
			return new int[] {0, 3};
		else if (0 <= x && x <= 2 && 6 <= y && y <= 8)
			return new int[] {0, 6};
		else if (3 <= x && x <= 5 && 0 <= y && y <= 2)
			return new int[] {3, 0};
		else if (3 <= x && x <= 5 && 3 <= y && y <= 5)
			return new int[] {3, 3};
		else if (3 <= x && x <= 5 && 6 <= y && y <= 8)
			return new int[] {3, 6};
		else if (6 <= x && x <= 8 && 0 <= y && y <= 2)
			return new int[] {6, 0};
		else if (6 <= x && x <= 8 && 3 <= y && y <= 5)
			return new int[] {6, 3};
		else
			return new int[] {6, 6};
	}
	private static boolean validateColumn(int x){
		boolean[] ch = new boolean[10];
		for (int i = 0; i < 9; i++) {
			if (ch[map[x][i]] && map[x][i] != 0)
				return false;
			ch[map[x][i]] = true;
		}
		return true;
	}

	private static boolean validateRow(int y){
		boolean[] ch = new boolean[10];
		for (int i = 0; i < 9; i++) {
			if (ch[map[i][y]] && map[i][y] != 0)
				return false;
			ch[map[i][y]] = true;
		}
		return true;
	}

	private static boolean validateArea(int x, int y){
		boolean[] ch = new boolean[10];
		for (int i = x; i < x + 3; i++) {
			for (int j = y; j < y + 3; j++) {
				if (ch[map[i][j]] && map[i][j] != 0)
					return false;
				ch[map[i][j]] = true;
			}
		}
		return true;
	}


}