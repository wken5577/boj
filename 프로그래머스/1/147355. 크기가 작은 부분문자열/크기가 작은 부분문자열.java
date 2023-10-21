import java.util.*;
class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long target = Long.valueOf(p);
        int n = t.length() - p.length() + 1;
        for (int i = 0; i < n; i++){
            String tmp = t.substring(i, i + p.length());
            long num = Long.valueOf(tmp);
            if (target >= num)
                answer++;
        }
        
        return answer;
    }
}