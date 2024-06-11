import java.io.*;
import java.util.*;


public class Main {
	static int n;
	static final int MOD = 1000000;

	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
		) {
			String str = br.readLine();
			n = str.length();
			int[] dy = new int[n];
			if (n == 1 || str.charAt(0) == '0'){
				if (str.charAt(0) != '0')
					System.out.println(1);
				else
					System.out.println(0);
				return;
			}
			dy[0] = 1;
			int num = Integer.parseInt(str.substring(0, 2));

			if (1 <= num && num <= 26){
				if (str.charAt(1) == '0' || str.charAt(0) == '0')
					dy[1] = 1;
				else
					dy[1] = 2;
			}
			else{
				if (!(str.charAt(1) == '0' || str.charAt(0) == '0'))
					dy[1] = 1;
			}

			for (int i = 2; i < n; i++) {
				num = Integer.parseInt(str.substring(i - 1, i + 1));
				if (str.charAt(i - 1) == '0')
					num = -1;
				char target = str.charAt(i);

				if (target == '0'){
					if (1 <= num && num <= 26)
						dy[i] = dy[i - 2] % MOD;
				}else{
					if (1 <= num && num <= 26)
						dy[i] = (dy[i - 1] + dy[i - 2]) % MOD;
					else
						dy[i] = dy[i - 1] % MOD;
				}
			}
			System.out.println(dy[n - 1] % MOD);

		}
	}


}

