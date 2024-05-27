import java.io.*;
import java.util.*;


public class Main {
	static int n;

	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
		) {
			n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int[] LIS = new int[n];
			int[] LDS = new int[n];

			Arrays.fill(LIS, 1);
			Arrays.fill(LDS, 1);

			for (int i = 1; i < n; i++) {
				for (int j = i - 1; j >= 0; j--) {
					if (arr[i] > arr[j])
						LIS[i] = Math.max(LIS[j] + 1, LIS[i]);
				}
			}

			for (int i = n - 2; i >= 0; i--) {
				for (int j = i + 1; j < n; j++) {
					if (arr[i] > arr[j])
						LDS[i] = Math.max(LDS[j] + 1, LDS[i]);
				}
			}

			int answer = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				answer = Math.max(answer, LIS[i] + LDS[i] - 1);
			}
			System.out.println(answer);
		}
	}


}

