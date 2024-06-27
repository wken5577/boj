import java.io.*;
import java.util.*;

public class Main {

	static int[][] dy;
	static boolean[] ch;
	static List<List<Integer>> list;
	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
		) {
			int n = Integer.parseInt(br.readLine());
			list = new ArrayList<>();
			for (int i = 0; i <= n; i++) {
				list.add(new ArrayList<>());
			}
			StringTokenizer st;
			for (int i = 0; i < n - 1; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				list.get(u).add(v);
				list.get(v).add(u);
			}

			dy = new int[n + 1][2];
			ch = new boolean[n + 1];

			dfs(1);
			System.out.println(Math.min(dy[1][0], dy[1][1]));
		}
	}

	private static void dfs(int v) {
		ch[v] = true;
		dy[v][0] = 1;

		List<Integer> nexts = list.get(v);

		for (Integer child : nexts) {
			if(ch[child]) continue;

			dfs(child);
			dy[v][1] += dy[child][0];

			dy[v][0] += Math.min(dy[child][0], dy[child][1]);
		}
	}

}

