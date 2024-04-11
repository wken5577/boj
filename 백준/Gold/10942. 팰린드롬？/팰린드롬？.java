import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int n, m;

	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
		) {
			n = Integer.parseInt(br.readLine());
			int[] arr = new int[n + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			m = Integer.parseInt(br.readLine());
			while (m-- > 0) {
				st = new StringTokenizer(br.readLine());
				int lt = Integer.parseInt(st.nextToken());
				int rt = Integer.parseInt(st.nextToken());
				bw.write(solution(lt, rt, arr));
			}
		}

	}

	private static String solution(int lt, int rt, int[] arr) {
		while (lt <= rt){
			if (arr[lt] == arr[rt]){
				lt++; rt--;
			}else
				return "0\n";
		}

		return "1\n";
	}

}