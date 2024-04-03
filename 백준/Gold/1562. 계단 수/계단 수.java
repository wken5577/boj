import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][][] dy;
	static int MOD = 1_000_000_000;

	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
		) {
			N = Integer.parseInt(br.readLine());
			dy = new int[N + 1][10][1 << 10];

			for (int i = 1; i <= 9; i++) {
				dy[1][i][1 << i] = 1;
			}

			//자리수
			for (int i = 2; i <= N; i++) {
				//이동 숫자
				for (int j = 0; j <= 9; j++) {
					// bit
					for (int k = 0; k < (1 << 10); k++) {
						if (j == 0){
							dy[i][j][k | 1 << j] = (dy[i][j][k | 1 << j] + dy[i - 1][1][k]) % MOD;
						}else if(j == 9){
							dy[i][j][k | 1 << j] = (dy[i][j][k | 1 << j] + dy[i - 1][8][k]) % MOD;
						}else{
							dy[i][j][k | 1 << j] = (dy[i][j][k | 1 << j] + dy[i - 1][j - 1][k] + dy[i - 1][j + 1][k]) % MOD;
						}
					}
				}

			}
			long ans = 0;
			for (int i = 0; i <= 9; i++) {
				ans = (ans + dy[N][i][(1 << 10) - 1]) % MOD;
			}
			System.out.println(ans);
		}

	}


}