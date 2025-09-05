import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            List<String> strings = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                strings.add(br.readLine());
            }
            Solution solution = new Solution();
            solution.solution(strings);
        }
    }
}

class Solution {
    public void solution(List<String> strings) {
        Map<Character, Integer> map = new HashMap<>();
        for (String string : strings) {
            int length = string.length();
            for (int i = 0; i < length; i++) {
                char c = string.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + (int) Math.pow(10, length - i - 1));
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
        }
        Map<Character, Integer> map2 = new HashMap<>();
        int num = 9;
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            if (!map2.containsKey((char) poll[0])) {
                map2.put((char) poll[0], num--);
            }
        }
        int sum = 0;
        for (String string : strings) {
            int length = string.length();
            for (int i = 0; i < length; i++) {
                char c = string.charAt(i);
                sum += map2.get(c) * (int) Math.pow(10, length - i - 1);
            }
        }
        System.out.println(sum);
    }
}

