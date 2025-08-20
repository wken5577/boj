import java.util.*;
import java.io.*;

class Solution {
    public int[] pm = new int[5];
    public int answer = 0;
    
    public int solution(int n, int[][] q, int[] ans) {
        DFS(0, 1, q, ans, n);
        
        return answer;
    }
    
    public void DFS(int L, int s, int[][]q, int[] ans, int n) {
        if (L == 5) {
            for (int i = 0; i < q.length; i++) {
                int numberAns = ans[i];
                int[] list = q[i];
                int cnt = 0;
                
                for (int j = 0; j < 5; j++) {
                    int target = pm[j];
                    for (int a : list) {
                        if (target == a) {
                            cnt++; break;
                        }
                    }
                }
                if (numberAns != cnt) {
                    return;
                }
            }
            answer++;
            // for (int j = 0; j < 5; j++) {
            //     System.out.print(pm[j] + " ");
            // }
            // System.out.println();
            return;
        }
        for (int i = s; i <= n; i++) {
            int prev = Integer.MIN_VALUE;
            if (L != 0) prev = pm[L - 1];
            if (i > prev) {
                pm[L] = i;
                DFS(L + 1, i, q, ans, n);
            }
        }
    }
}