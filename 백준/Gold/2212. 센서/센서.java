import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
          n = Integer.parseInt(br.readLine());
          k = Integer.parseInt(br.readLine());
          StringTokenizer st = new StringTokenizer(br.readLine());
          int[] arr = new int[n];
          int[] dis = new int[n];
          for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
          }
          if (k >= n){
              System.out.println(0);
              return;
          }
          Arrays.sort(arr);
          for (int i = 1; i < n; i++) {
              dis[i - 1] = Math.abs(arr[i] - arr[i - 1]);
          }
          dis = Arrays.stream(dis)
                  .boxed()
                  .sorted(Comparator.reverseOrder())
                  .mapToInt(Integer::intValue)
                  .toArray();
          int answer = 0;
          for (int i = k - 1; i < n; i++) {
            answer += dis[i];
          }
          System.out.println(answer);
        }

    }



}
