import java.io.*;
import java.util.*;

public class Main {
	static int LIMIT = 2_000;
	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
		) {
			int target = Integer.parseInt(br.readLine());

			Queue<int[]> queue = new LinkedList<>();
			boolean[][] ch = new boolean[LIMIT][LIMIT];

			queue.add(new int[]{1, 0});
			ch[1][0] = true;
			int level = 0;
			while (!queue.isEmpty()) {
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					int[] now = queue.poll();
					// copy
					int[] next;
					next = new int[] {now[0], now[0]};
					if (next[0] < LIMIT && next[1] < LIMIT && !ch[next[0]][next[1]]){
						queue.add(next);
						ch[next[0]][next[1]] = true;
						if (next[0] == target){
							System.out.println(level + 1);
							return;
						}
					}

					//paste
					next = new int[] {now[0] + now[1], now[1]};
					if (next[0] < LIMIT && next[1] < LIMIT && !ch[next[0]][next[1]] && now[1] != 0){
						queue.add(next);
						ch[next[0]][next[1]] = true;
						if (next[0] == target){
							System.out.println(level + 1);
							return;
						}
					}

					//delete
					next = new int[] {now[0] - 1, now[1]};
					if (next[0] < LIMIT && next[1] < LIMIT && next[0] >= 1 && !ch[next[0]][next[1]]){
						queue.add(next);
						ch[next[0]][next[1]] = true;
						if (next[0] == target){
							System.out.println(level + 1);
							return;
						}
					}
				}
				level++;
			}
		}
	}

}

