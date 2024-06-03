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
			map = new int[n][3];
			int[][] maxDY = new int[n][3];
			int[][] minDY = new int[n][3];
			StringTokenizer st;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				map[i][0] = Integer.parseInt(st.nextToken());
				map[i][1] = Integer.parseInt(st.nextToken());
				map[i][2] = Integer.parseInt(st.nextToken());
			}
			maxDY[0][0] = map[0][0];
			maxDY[0][1] = map[0][1];
			maxDY[0][2] = map[0][2];

			minDY[0][0] = map[0][0];
			minDY[0][1] = map[0][1];
			minDY[0][2] = map[0][2];

			for (int i = 1; i < n; i++) {
				minDY[i][0] = Math.min(minDY[i - 1][0], minDY[i - 1][1]) + map[i][0];
				minDY[i][1] = Math.min(minDY[i - 1][0], Math.min(minDY[i - 1][1], minDY[i - 1][2])) + map[i][1];
				minDY[i][2] = Math.min(minDY[i - 1][1], minDY[i - 1][2]) + map[i][2];

				maxDY[i][0] = Math.max(maxDY[i - 1][0], maxDY[i - 1][1]) + map[i][0];
				maxDY[i][1] = Math.max(maxDY[i - 1][0], Math.max(maxDY[i - 1][1], maxDY[i - 1][2])) + map[i][1];
				maxDY[i][2] = Math.max(maxDY[i - 1][1], maxDY[i - 1][2]) + map[i][2];
			}
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < 3; i++) {
				max = Math.max(maxDY[n - 1][i], max);
				min = Math.min(minDY[n - 1][i], min);
			}
			System.out.println(max + " " + min);
		}
	}

}

