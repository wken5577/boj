import java.util.*;

class Solution {
    int[] s = new int[]{0, 3, 2, 1, 0, 1, 2, 3};
    
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<Character, Integer> map = new HashMap();
        
        for(int i = 0; i < survey.length; i++){
            int a = map.getOrDefault(survey[i].charAt(0), 0);
            int b = map.getOrDefault(survey[i].charAt(1), 0);
            
            if (choices[i] <= 3)
                map.put(survey[i].charAt(0), a + s[choices[i]]);
            else
                map.put(survey[i].charAt(1), b + s[choices[i]]);

        }
        int r = map.getOrDefault('R', 0);
        int t = map.getOrDefault('T', 0);
        int c = map.getOrDefault('C', 0);
        int f = map.getOrDefault('F', 0);
        int j = map.getOrDefault('J', 0);
        int m = map.getOrDefault('M', 0);
        int a = map.getOrDefault('A', 0);
        int n = map.getOrDefault('N', 0);
        
        if (r >= t)
            answer += "R";
        else if (r < t)
            answer += "T";
        
        if (c >= f)
            answer += "C";
        else if (c < f)
            answer += "F";
        
        if (j >= m)
            answer += "J";
        else if (j < m)
            answer += "M";
        
        if (a >= n)
            answer += "A";
        else if (a < n)
            answer += "N";
        
        return answer;
    }
}