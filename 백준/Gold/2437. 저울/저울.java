import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                int s = Integer.parseInt(st.nextToken());
                arr[i] = s;
            }
            Arrays.sort(arr);
            int target = 1;
            for (int integer : arr) {
                if (target < integer)
                    break;
                target = target + integer;
            }
            System.out.println(target == 0 ? 1 : target);
        }

    }
}
