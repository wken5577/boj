import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] arr, dy;
	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
		) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n];
			dy = new int[n];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			dy[0] = arr[0];
			for (int i = 1; i < n; i++) {
				dy[i] = Math.max(dy[i - 1] + arr[i], arr[i]);
			}
			int answer = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				answer = Math.max(answer, dy[i]);
			}
			bw.write(answer + "\n");
		}
	}

}