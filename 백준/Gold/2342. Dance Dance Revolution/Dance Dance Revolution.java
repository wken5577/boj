import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int n;
	static int[] arr;
	static int[][][] dy;

	static int MAX = 500_000;

	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
		) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = new int[100001];
			int idx = 1;
			while(true){
				int num = Integer.parseInt(st.nextToken());
				if (num == 0)
					break;
				arr[idx++] = num;
			}

			dy = new int[idx][5][5];

			for (int i = 0; i < idx; i++) {
				for (int left = 0; left < 5; left++) {
					for (int right = 0; right < 5; right++) {
						dy[i][left][right] = MAX;
					}
				}
			}
			dy[0][0][0] = 0;
			for (int i = 1; i < idx; i++) {
				int next = arr[i];
				for (int left = 0; left < 5; left++) {
					for (int right = 0; right < 5; right++) {
						// 왼발로 이동
						if (right != next) dy[i][next][right] = Math.min(dy[i][next][right],
							dy[i - 1][left][right] + calcPrice(left, next));

						// 오른발로 이동
						if (left != next) dy[i][left][next] = Math.min(dy[i][left][next],
							dy[i - 1][left][right] + calcPrice(right, next));
					}
				}
			}
			int answer = Integer.MAX_VALUE;
			int last = arr[idx - 1];
			for (int i = 0; i < 5; i++) {
				answer = Math.min(dy[idx - 1][last][i], answer);
				answer = Math.min(dy[idx - 1][i][last], answer);
			}
			System.out.println(answer);
		}

	}

	private static int calcPrice(int from, int to) {
		if (from == 0)
			return 2;
		//같은 위치 누르기
		if (from == to)
			return 1;

		// 인접한지 확인 from에서 1 더하고 빼서 to랑 같은지 확인
		int tmp = from + 1 == 5 ? 1 : from + 1;
		if (tmp == to)
			return 3;

		tmp = from - 1 == 0 ? 4 : from - 1;
		if (tmp == to)
			return 3;

		return 4;
	}

}