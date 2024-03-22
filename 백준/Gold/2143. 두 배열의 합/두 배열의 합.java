import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int n, t, m;
	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
		) {
			t = Integer.parseInt(br.readLine());
			n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arrA = new int[n];
			for (int i = 0; i < n; i++) {
				arrA[i] = Integer.parseInt(st.nextToken());
			}

			m = Integer.parseInt(br.readLine());
			int[] arrB = new int[m];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				arrB[i] = Integer.parseInt(st.nextToken());
			}

			int sumA, sumB;
			long ans = 0;
			Map<Integer, Integer> map = new HashMap<>();
			for (int sizeA = 1; sizeA <= n; sizeA++) {
				sumA = 0;
				for (int i = 0; i < sizeA; i++) {
					sumA += arrA[i];
				}
				map.put(sumA, map.getOrDefault(sumA, 0) + 1);
				for (int i = sizeA; i < n; i++) {
					sumA += arrA[i];
					sumA -= arrA[i - sizeA];
					map.put(sumA, map.getOrDefault(sumA, 0) + 1);
				}
			}

			for (int sizeB = 1; sizeB <= m; sizeB++) {
				sumB = 0;
				for (int i = 0; i < sizeB; i++) {
					sumB += arrB[i];
				}
				int target;
				target = t - sumB;
				ans += map.getOrDefault(target, 0);
				for (int i = sizeB; i < m; i++) {
					sumB += arrB[i];
					sumB -= arrB[i - sizeB];
					target = t - sumB;
					ans += map.getOrDefault(target, 0);
				}
			}

			System.out.println(ans);
		}

	}


}