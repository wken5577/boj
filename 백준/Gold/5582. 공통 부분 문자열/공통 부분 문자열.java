import java.io.*;
import java.util.*;

public class Main {
	static int[][] dy;
	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
		) {
			String a = br.readLine();
			String b = br.readLine();

			dy = new int[a.length() + 1][b.length() + 1];
			int answer = Integer.MIN_VALUE;
			for (int i = 1; i <= a.length(); i++) {
				for (int j = 1; j <= b.length(); j++) {
					if (a.charAt(i - 1) == b.charAt(j - 1))
						dy[i][j] =  dy[i - 1][j - 1] + 1;
					answer = Math.max(answer, dy[i][j]);
				}
			}

			System.out.println(answer);
		}
	}

}

