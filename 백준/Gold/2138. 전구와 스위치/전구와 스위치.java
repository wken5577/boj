import java.io.*;
import java.util.*;

import static java.lang.System.exit;

public class Main {
    static int n;
    static String[] strArr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String s1 = st.nextToken();
        st = new StringTokenizer(br.readLine());
        String target = st.nextToken();

        if (s1.compareTo(target) == 0){
            System.out.println(0);
            return;
        }

        int answer = Integer.MAX_VALUE;
        int cnt = 0;
        char[] s1Chars = s1.toCharArray();
        char[] targetChars = target.toCharArray();
        int res = getCnt(true, s1Chars, targetChars);
        if (new String(s1Chars).compareTo(target) == 0)
            answer = res;
        s1Chars = s1.toCharArray();
        int res2 = getCnt(false, s1Chars, targetChars);
            if (new String(s1Chars).compareTo(target) == 0)
                answer = Math.min(res2, answer);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static int getCnt(boolean pressOne, char[] s1Chars, char[] targetChars) {
        int cnt = 0;
        if (pressOne){
            s1Chars[0] = s1Chars[0] == '0' ? '1' : '0';
            s1Chars[1] = s1Chars[1] == '0' ? '1' : '0';
            cnt++;
        }
        for (int i = 1; i < n; i++) {
            if (s1Chars[i - 1] != targetChars[i - 1]) {
                int prev = i - 1;
                int next = i + 1;
                s1Chars[i] = s1Chars[i] == '0' ? '1' :'0';
                s1Chars[prev] = s1Chars[prev] == '0' ? '1' :'0';
                if (next < n)
                    s1Chars[next] = s1Chars[next] == '0' ? '1' :'0';
                cnt++;
            }
        }
        return cnt;
    }

}
