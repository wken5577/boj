import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int n;
	static int ans = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
		) {
			n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			int[] tmp = new int[n];
			int[] idxArr = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int size = 0;
			tmp[size++] = arr[0];
			idxArr[0] = 0;

			for (int i = 1; i < n; i++) {
				if(tmp[size - 1] < arr[i]){
					tmp[size++] = arr[i];
					idxArr[i] = size - 1;
				}else{
					int target = Arrays.binarySearch(tmp, 0, size, arr[i]);
					if (target < 0){
						target *= -1;
						target -= 1;
						tmp[target] = arr[i];
					}
					idxArr[i] = target;
				}
			}

			int num = size - 1;
			TreeSet<Integer> set = new TreeSet<>();
			for (int i = n - 1; i >= 0; i--) {
				if (idxArr[i] == num){
					num--;
					set.add(arr[i]);
				}
			}
			bw.write(size + "\n");
			for (Integer integer : set) {
				bw.write(integer + " ");
			}
			bw.write("\n");

		}

	}



}