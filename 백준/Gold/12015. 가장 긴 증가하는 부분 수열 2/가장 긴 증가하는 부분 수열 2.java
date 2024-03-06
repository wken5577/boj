import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
		) {
			n = Integer.parseInt(br.readLine());
			int arr[] = new int[n];
			int ans[] = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int size = 0;
			ans[size++] = arr[0];
			for (int i = 1; i < n; i++) {
				if (ans[size - 1] < arr[i]){
					ans[size++] = arr[i];
				}else{
					int target = Arrays.binarySearch(ans, 0, size, arr[i]);
					if (target < 0) {
						target *= -1;
						target -= 1;
						ans[target] = arr[i];
					}
				}
			}
			System.out.println(size);

		}

	}


}