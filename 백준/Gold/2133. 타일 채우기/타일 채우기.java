import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
		) {
			int n = Integer.parseInt(br.readLine());

			int[] dy = new int[n + 5];

			if (n % 2 == 1){
				System.out.println(0);
				return;
			}
			dy[0] = 1;
			dy[2] = 3;
			dy[4] = 11;

			for (int i = 6; i <= n; i += 2) {
				int num = dy[i - 2] * dy[2];
				for(int s = i - 4; s >= 1; s--){
					if (s % 2 == 1)
						continue;
					num += dy[s] * 2;
				}
				num += 2;
				dy[i] = num;
			}
			System.out.println(dy[n]);
		}

	}

}

