import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine());
            Solution solution = new Solution();

            for (int i = 0; i < T; i++) {
                String command = br.readLine();
                int n = Integer.parseInt(br.readLine());
                String str = br.readLine();
                LinkedList<Integer> list = new LinkedList<>();

                if (n > 0) {
                    str = str.substring(1, str.length() - 1);
                    String[] strs = str.split(",");
                    for (String s : strs) {
                        list.add(Integer.parseInt(s));
                    }
                }

                solution.solution(command, list);
            }
        }
    }
}

class Solution {
    public void solution(String command, LinkedList<Integer> list) {
        int cnt = 1;
        for (int i = 0; i < command.length(); i++) {
            char c = command.charAt(i);

            if (c == 'R') {
                cnt++;
            } else {
                if (list.isEmpty()) {
                    System.out.println("error");
                    return;
                }
                if (cnt % 2 == 0) {
                    list.removeLast();
                } else list.removeFirst();
            }
        }

        List<Integer> answer = new ArrayList<>();
        if (cnt % 2 == 0) {
            while (!list.isEmpty()) {
                answer.add(list.removeLast());
            }
        } else {
            while (!list.isEmpty()) {
                answer.add(list.removeFirst());
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < answer.size(); i++) {
            sb.append(answer.get(i));
            if (i != answer.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(']');
        System.out.println(sb);
    }

}

