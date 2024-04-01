import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int N, S;
	static Map<Integer, Integer> map = new HashMap<>();
	static long ans = 0;

	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
		) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			int arr[] = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			searchLeft(0, N / 2, arr, 0);
			searchRight(N / 2, N, arr, 0);
			if (S == 0)
				ans--;
			System.out.println(ans);
		}

	}

	private static void searchRight(int s, int e, int[] arr, int sum) {
		if (s == e){
			ans += map.getOrDefault(S - sum, 0);
			return;
		}

		searchRight(s + 1, e, arr, sum + arr[s]);
		searchRight(s + 1, e, arr, sum);
	}

	private static void searchLeft(int s, int e, int[] arr, int sum) {
		if (s == e){
			map.put(sum, map.getOrDefault(sum, 0) + 1);
			return;
		}
		searchLeft(s + 1, e, arr, sum + arr[s]);
		searchLeft(s + 1, e, arr, sum);
	}

}