import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int n;
	static int ans = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
		) {
			n = Integer.parseInt(br.readLine());
			StringTokenizer st;
			int[][] map = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// int[][] res = moveLeft(map);
			// int[][] res = moveRight(map);
			// int[][] res = moveBottom(map);
			// int[][] res = moveTop(map);



			// for (int[] re : res) {
			// 	for (int i : re) {
			// 		System.out.print(i +" ");
			// 	}
			// 	System.out.println();
			// }

			search(map, 0);
			System.out.println(ans);
		}

	}

	private static void search(int[][] map, int depth) {
		if (depth == 5){
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				max = Math.max(max, Arrays.stream(map[i]).max().getAsInt());
			}
			ans = Math.max(ans, max);
			return;
		}

		search(moveLeft(map), depth + 1);
		search(moveRight(map), depth + 1);
		search(moveTop(map), depth + 1);
		search(moveBottom(map), depth + 1);
	}

	private static int[][] moveLeft(int[][] map) {
		int[][] res = copyMap(map);
		boolean[][] ch = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 1; j < n; j++) {
				if (res[i][j] != 0){
					int next = j - 1;
					while (next >= 0 && res[i][next] == 0)
						next--;
					if (next == -1){
						res[i][0] = res[i][j];
						res[i][j] = 0;
					}
					else{
						// 다른 애랑 부딛힘
						if (res[i][next] != res[i][j] || ch[i][next]){
							res[i][next + 1] = res[i][j];
							res[i][next] = res[i][next];
							if(next != j - 1)
								res[i][j] = 0;
						}else {
							// 움직이다가 같은애랑 부딛힘
							res[i][next] = res[i][j] * 2;
							res[i][j] = 0;
							ch[i][next] = true;
						}
					}

				}
			}
		}
		return res;
	}

	private static int[][] moveRight(int[][] map) {
		int[][] res = copyMap(map);
		boolean[][] ch = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = n - 2; j >= 0; j--) {
				if (res[i][j] != 0){
					int next = j + 1;
					while (next < n && res[i][next] == 0)
						next++;
					if (next == n){
						res[i][n - 1] = res[i][j];
						res[i][j] = 0;
					}
					else{
						// 다른 애랑 부딛힘
						if (res[i][next] != res[i][j] || ch[i][next]){
							res[i][next - 1] = res[i][j];
							res[i][next] = res[i][next];
							if (next != j + 1)
								res[i][j] = 0;
						}else {
							// 움직이다가 같은애랑 부딛힘
							res[i][next] = res[i][j] * 2;
							ch[i][next] = true;
							res[i][j] = 0;
						}
					}
				}
			}
		}
		return res;
	}

	private static int[][] moveTop(int[][] map) {
		int[][] res = copyMap(map);
		boolean[][] ch = new boolean[n][n];

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n; j++) {

				if (res[i][j] != 0){
					int next = i - 1;
					while (next >= 0 && res[next][j] == 0)
						next--;
					if (next == -1){
						res[0][j] = res[i][j];
						res[i][j] = 0;
					}
					else{
						 // 다른 애랑 부딛힘
						if (res[next][j] != res[i][j] || ch[next][j]){
							res[next + 1][j] = res[i][j];
							res[next][j] = res[next][j];
							if (next != i - 1)
								res[i][j] = 0;
						}else {
							// 움직이다가 같은애랑 부딛힘
							res[next][j] = res[i][j] * 2;
							ch[next][j] = true;
							res[i][j] = 0;
						}
					}

				}

			}
		}
		return res;
	}

	private static int[][] copyMap(int[][] map) {
		int[][] res = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				res[i][j] = map[i][j];
			}
		}
		return res;
	}

	private static int[][] moveBottom(int[][] map) {
		int[][] res = copyMap(map);
		boolean[][] ch = new boolean[n][n];

		for (int i = n - 2; i >= 0; i--) {
			for (int j = 0; j < n; j++) {
				if (res[i][j] != 0){
					int next = i + 1;
					while (next < n && res[next][j] == 0)
						next++;
					if (next == n){
						res[n - 1][j] = res[i][j];
						res[i][j] = 0;
					}
					else{
						// 다른 애랑 부딛힘
						if (res[next][j] != res[i][j] || ch[next][j]){
							res[next - 1][j] = res[i][j];
							res[next][j] = res[next][j];
							if (next != i + 1)
								res[i][j] = 0;
						}else {
							// 움직이다가 같은애랑 부딛힘
							res[next][j] = res[i][j] * 2;
							ch[next][j] = true;
							res[i][j] = 0;
						}
					}
				}

			}
		}
		return res;
	}

}