import java.io.*;
import java.util.*;


public class Main {
	static int n;
	static int[] costs, dy, ind;

	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
		) {
			n = Integer.parseInt(br.readLine());
			StringTokenizer st;

			costs = new int[n];
			dy = new int[n];
			ind = new int[n];
			List<List<Integer>> map = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				map.add(new ArrayList<>());
			}

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int cost = Integer.parseInt(st.nextToken());
				costs[i] = cost;
				int build = Integer.parseInt(st.nextToken());
				while (build != -1){
					ind[i]++;
					map.get(build - 1).add(i);
					build = Integer.parseInt(st.nextToken());
				}
			}

			Queue<Integer> queue = new LinkedList<>();

			for (int i = 0; i < n; i++) {
				if (ind[i] == 0){
					queue.add(i);
				}
			}

			while(!queue.isEmpty()){
				int now = queue.poll();
				dy[now] += costs[now];
				for(Integer next : map.get(now)){
					ind[next]--;
					if(ind[next] == 0){
						queue.add(next);
					}
					dy[next] = Math.max(dy[next], dy[now]);
				}
			}

			for (int ans : dy) {
				System.out.println(ans);
			}
		}
	}


}

