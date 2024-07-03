import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] arr;
	static int[][]  dy;
	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
		) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n];
			dy = new int[n][2];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int answer = arr[0];
			dy[0][0] = arr[0];
			dy[0][1] = arr[0];
			for (int i = 1; i < n; i++) {
				//경우 1
				dy[i][0] = Math.max(dy[i - 1][0] + arr[i], arr[i]);

				//경우 2
				dy[i][1] = Math.max(dy[i - 1][0], dy[i - 1][1] + arr[i]);
				answer = Math.max(answer, Math.max(dy[i][0], dy[i][1]));
			}

			bw.write(answer + "\n");
		}
	}

}
