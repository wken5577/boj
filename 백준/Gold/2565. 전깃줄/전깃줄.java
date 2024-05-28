import java.io.*;
import java.util.*;


public class Main {
	static int n;

	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
		) {
			n = Integer.parseInt(br.readLine());
			StringTokenizer st;
			List<int[]> list = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				list.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
			}

			list.sort(Comparator.comparingInt(o -> o[0]));
			int[] dy = new int[n];
			Arrays.fill(dy, 1);
			int max = Integer.MIN_VALUE;
			for (int i = 1; i < n; i++) {
				for (int j = i - 1; j >= 0; j--) {
					if (list.get(i)[1] > list.get(j)[1]){
						dy[i] = Math.max(dy[i], dy[j] + 1);
						max = Math.max(dy[i], max);
					}
				}
			}
			System.out.println(n - max);
		}
	}


}

