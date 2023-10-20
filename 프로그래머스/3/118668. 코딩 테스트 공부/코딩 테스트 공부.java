import java.util.*;


class Solution {
    int[][] dy = new int[500][500];
    static final int INF = (int) 1e9;
    
    public int solution(int alp, int cop, int[][] problems) {
        int[] max = getMax(problems);
        for(int i = 0; i < dy.length; i++){
            Arrays.fill(dy[i], INF);
        }
        
        if (max[0] <= alp && max[1] <= cop)
            return 0;
        dy[alp][cop] = 0;
        for(int i = alp; i < 500; i++){
            for(int j = cop; j < 500; j++){
                if (i == alp && j == cop)
                    continue;
                //alp + 1
                if (i - 1 >= 0)
                    dy[i][j] = Math.min(dy[i][j], dy[i - 1][j] + 1);
                
                //cop + 1
                 if (j - 1 >= 0)
                    dy[i][j] = Math.min(dy[i][j], dy[i][j - 1] + 1);
                
                //solve problem
                solveProblem(i, j, problems);
            }
        }
        
        return getAnswer(max);
    }
    
    public int getAnswer(int[] max){
        int answer = Integer.MAX_VALUE;
        for(int i = max[0]; i < 500; i++){
            for(int j = max[1]; j < 500; j++){
                answer = Math.min(dy[i][j], answer);
            }
        }
        return answer;
    }
    
    public void solveProblem(int a, int b, int[][] problems){
        for(int i = 0; i < problems.length; i++){
            int aLimit = problems[i][0];
            int bLimit = problems[i][1];
            int problemA = problems[i][2];
            int problemB = problems[i][3];
            int cost = problems[i][4];

            if (a - problemA < aLimit) continue;
            if (b - problemB < bLimit) continue; 

            dy[a][b] = Math.min(dy[a][b], dy[a-problemA][b-problemB] + cost);
        }
    }
    
    
    public int[] getMax(int[][] problems){
        int[] ret = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        
        for(int i = 0; i < problems.length; i++){
            ret[0] = Math.max(problems[i][0], ret[0]);
            ret[1] = Math.max(problems[i][1], ret[1]);
        }
        
        return ret;
    }
}