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


	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
		) {
			N = Integer.parseInt(br.readLine());
			long arrX[] = new long[N + 1];
			long arrY[] = new long[N + 1];
			StringTokenizer st;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				arrX[i] = Long.parseLong(st.nextToken());
				arrY[i] = Long.parseLong(st.nextToken());
			}
			arrX[N] = arrX[0];
			arrY[N] = arrY[0];
			long sum1 = 0;
			for (int i = 0; i < N; i++) {
				sum1 += arrX[i] * arrY[i + 1];
			}

			long sum2 = 0;
			for (int i = 0; i < N; i++) {
				sum2 += arrY[i] * arrX[i + 1];
			}

			double tmp = (0.5 * (double)Math.abs(sum1 - sum2));
			// 2째 자리에서 반올림하여 print
			bw.write(String.format("%.1f", tmp));
		}

	}


}