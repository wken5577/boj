import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int n, m;

	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
		) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			int[] ind = new int[n + 1];
			Map<Integer, Set<Integer>> map = new HashMap<>();
			Set<Integer>[] set = new Set[n + 1];
			for (int i = 1; i <= n; i++) {
				set[i] = new HashSet<>();
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				int prev = -1;
				for (int j = 0; j < num; j++) {
					int singer = Integer.parseInt(st.nextToken());
					if (prev != -1){
						set[prev].add(singer);
						Set<Integer> tmp = map.getOrDefault(singer, new HashSet<>());
						tmp.add(prev);
						map.put(singer, tmp);
						ind[singer] = tmp.size();
					}
					prev = singer;
				}
			}
			solution(set, ind);
		}

	}

	private static void solution(Set<Integer>[] set, int[] ind) {
		Queue<Integer> queue = new LinkedList<>();
		Queue<Integer> answerQueue = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			if (ind[i] == 0)
				queue.add(i);
		}
		boolean[] ch = new boolean[n + 1];
		while(!queue.isEmpty()){
			Integer now = queue.poll();
			answerQueue.add(now);
			ch[now] = true;
			calcInd(now, ind, set, queue);
		}
		for (int i = 1; i <= n; i++) {
			if (!ch[i] && ind[i] == 0)
				answerQueue.add(i);
		}
		if (answerQueue.size() == n){
			for (Integer integer : answerQueue) {
				System.out.println(integer);
			}
		}else{
			System.out.println(0);
		}
	}

	private static void calcInd(Integer now, int[] ind, Set<Integer>[] set, Queue<Integer> queue) {
		for (Integer i : set[now]) {
			ind[i]--;
			if (ind[i] == 0)
				queue.add(i);
		}
	}

}