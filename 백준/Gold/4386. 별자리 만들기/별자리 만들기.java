import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] unf;

	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
		) {
			n = Integer.parseInt(br.readLine());
			List<float[]> list = new ArrayList<>();
			StringTokenizer st;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				float x = Float.parseFloat(st.nextToken());
				float y = Float.parseFloat(st.nextToken());
				list.add(new float[]{x, y});
			}

			unf = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				unf[i] = i;
			}

			float res = 0;
			List<float[]> disList = searchDis(list);
			disList.sort((o1, o2) -> (int)(o1[2] - o2[2]));
			for (int i = 0; i < disList.size(); i++) {
				float[] data = disList.get(i);
				if (find((int)data[0]) != find((int)data[1])){
					union((int)data[0], (int)data[1]);
					res += data[2];
				}
			}
			System.out.println(res);
		}
	}
	private static List<float[]> searchDis(List<float[]> points) {
		List<float[]> res = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) continue;
				float[] now = points.get(i);
				float[] next = points.get(j);
				float dis = (float)Math.sqrt(Math.pow(Math.abs(now[0] - next[0]), 2) +
					Math.pow(Math.abs(now[1] - next[1]), 2));
				res.add(new float[] {i, j, dis});
			}
		}
		return res;
	}

	public static void union(int a, int b){
		int fa = find(a);
		int fb = find(b);
		if (fa != fb) unf[fa] = fb;
	}

	private static int find(int v) {
		if (unf[v] == v) return v;
		return unf[v] = find(unf[v]);
	}
}