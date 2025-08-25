import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] split = br.readLine().split(" ");
            int n = Integer.parseInt(split[0]);
            int k = Integer.parseInt(split[1]);
            int[] arr = new int[n];
            split = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(split[i]);
            }

            Solution solution = new Solution();
            solution.solution(n, k, arr);
        }
    }
}

class Solution {
    public void solution(int n, int k, int[] arr) {
        int answer = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);

        for (int i = 1; i < n; i++) {
            pq.offer(new int[] {arr[i] - arr[i - 1], i});
        }
        TreeSet<Integer> set = new TreeSet<>();
        while (!pq.isEmpty() && set.size() < k - 1) {
            int[] poll = pq.poll();
            set.add(poll[1]);
        }
        int start = 0;
        while (start < n) {
            Integer end = set.pollFirst();
            if (end == null) end = n;
            answer += arr[end - 1] - arr[start];

            start = end;
        }


        System.out.println(answer);
    }
}

