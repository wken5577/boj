import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
		) {
			int n = Integer.parseInt(br.readLine());

			List<int[]> list = new ArrayList<>();
			StringTokenizer st;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				list.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
			}

			list.sort(Comparator.comparingInt(o -> o[0]));
			Queue<int[]> queue = new LinkedList<>(list);
			PriorityQueue<int[]> pq = new PriorityQueue<>(
				Comparator.comparingInt(o -> o[1]));

			int date = 1;
			while(!queue.isEmpty()){
				while (!queue.isEmpty() && queue.peek()[0] <= date) {
					pq.add(queue.poll());
				}

				while (pq.size() > date)
					pq.poll();
				date++;
			}
			int answer = 0;
			while (!pq.isEmpty())
				answer += pq.poll()[1];

			System.out.println(answer);
		}

	}

}

