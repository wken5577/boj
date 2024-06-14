import java.io.*;
import java.util.*;


public class Main {
	static int n;
	static List<int[]> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
		) {
			n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				String[] s = str.split(" ");
				list.add(new int[] {Integer.parseInt(s[0]), Integer.parseInt(s[1])});
			}

			int[] dy = new int[n + 1];

			for (int i = 0; i < n; i++) {
				if(i != 0)
					dy[i] = Math.max(dy[i - 1], dy[i]);
				int t = list.get(i)[0];
				int p = list.get(i)[1];
				if (i + t <= n) {
					dy[i + t] = Math.max(dy[i + t], dy[i] + p);
				}
			}
			int answer = 0;
			for (int i : dy) {
				answer = Math.max(i, answer);
			}
			System.out.println(answer);
		}
	}

}

