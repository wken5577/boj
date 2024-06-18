import java.io.*;
import java.util.*;

public class Main {
	static int n, t;
	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
		) {

			t = Integer.parseInt(br.readLine());
			StringTokenizer st;
			while (t-- > 0){
				n = Integer.parseInt(br.readLine());
				st = new StringTokenizer(br.readLine());
				List<Integer> list = new ArrayList<>();
				for (int i = 0; i < n; i++) {
					list.add(Integer.parseInt(st.nextToken()));
				}
				int price = Integer.parseInt(br.readLine());

				int[]dy = new int[price + 1];
				dy[0] = 1;
				list.sort(Comparator.comparingInt(o -> o));
				for (Integer coin : list) {
					for (int i = coin; i <= price; i++) {
						dy[i] = dy[i - coin] + dy[i];
					}
				}
				bw.write(dy[price] + "\n");
			}

		}
	}

}

