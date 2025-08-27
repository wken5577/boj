import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());

            for (int i = 0; i < t; i++) {
                int n = Integer.parseInt(br.readLine());
                String[] split = br.readLine().split(" ");
                PriorityQueue<Long> pq = new PriorityQueue<>();
                for (int j = 0; j < n; j++) {
                    pq.add(Long.parseLong(split[j]));
                }
                Solution solution = new Solution();
                solution.solution(pq);
            }


        }
    }
}

class Solution {
    public void solution(PriorityQueue<Long> pq) {
        long answer = 0;

        while (pq.size() > 1) {
            long a = pq.poll();
            long b = pq.poll();

            pq.add(a + b);
            answer += a + b;
        }

        System.out.println(answer);
    }
}

