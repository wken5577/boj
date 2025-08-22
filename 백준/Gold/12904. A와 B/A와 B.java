import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String S = br.readLine();
            String T = br.readLine();
            Solution solution = new Solution();

            solution.solution(S, T);
        }
    }
}

class Solution {
    public void solution(String S, String T) {
        StringBuffer sb = new StringBuffer(T);
        while (sb.length() > S.length()) {
            int last = sb.length() - 1;
            char a = sb.charAt(last);
            sb.deleteCharAt(last);
            if (a == 'B') {
                sb.reverse();
            }
        }
        String res = sb.toString();
        if (res.equals(S)) {
            System.out.println("1");
        }else {
            System.out.println("0");
        }
    }

}

