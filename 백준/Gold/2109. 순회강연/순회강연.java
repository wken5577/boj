import java.io.*;
import java.util.*;

public class Main {
    static int n, p, d;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            n = Integer.parseInt(br.readLine());
            StringTokenizer st;
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
                if (o1[0] == o2[0])
                    return o2[1] - o1[1];
                return o2[0] - o1[0];
            });
            int[] price = new int[10001];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                p = Integer.parseInt(st.nextToken());
                d = Integer.parseInt(st.nextToken());
                pq.add(new int[]{p, d});
            }

            while (!pq.isEmpty()) {
                int[] lecture = pq.poll();
                int d = lecture[1];
                for (int i = d; i >= 1; i--) {
                    if (price[i] == 0) {
                        price[i] = lecture[0];
                        break;
                    }
                }
            }
            int ans = 0;
            for (int p : price) {
                ans += p;
            }
            bw.write(String.valueOf(ans));
        }

    }
}
