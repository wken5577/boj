import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String str = br.readLine();
            String[] split = str.split(" ");

            int n = Integer.parseInt(split[0]);
            int m = Integer.parseInt(split[1]);
            int arr[] = new int[n];

            str = br.readLine();
            split = str.split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(split[i]);
            }

            Solution solution = new Solution();
            solution.solution(n, m, arr);
        }
    }
}

class Solution {
    public void solution(int n, int m, int[] arr) {
        int answer = 0;
        PriorityQueue<Integer> positive = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> negative = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                positive.add(arr[i]);
            } else {
                negative.add(arr[i]);
            }
        }

        boolean first = true;
        while (!positive.isEmpty() || !negative.isEmpty()) {
            int positiveMax = 0;
            int negativeMax = 0;

            int i = 0;
            while (!positive.isEmpty() && i < m) {
                positiveMax = Math.max(positive.poll(), positiveMax);
                i++;
            }

            i = 0;
            while (!negative.isEmpty() && i < m) {
                negativeMax = Math.max(negative.poll() * -1, negativeMax);
                i++;
            }

            if (first) {
                if (positiveMax > Math.abs(negativeMax)) {
                    answer += positiveMax;
                    answer += negativeMax * 2;
                } else {
                    answer += negativeMax;
                    answer += positiveMax * 2;
                }
                first = false;
                continue;
            }

            answer += positiveMax * 2;
            answer += negativeMax * 2;
        }
        System.out.println(answer);
    }
}

