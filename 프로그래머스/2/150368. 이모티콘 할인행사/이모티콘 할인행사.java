import java.util.*;

class Solution {
    int[] pm;
    int[] rate = {10, 20 ,30, 40};
    TreeSet<int[]> set;
    
    public int[] solution(int[][] users, int[] emoticons) {
        pm = new int[emoticons.length];
        set = new TreeSet<>((o1, o2) ->{
            if (o1[0] == o2[0])
                return o2[1] - o1[1];
            return o2[0] - o1[0];
        });
        DFS(0, users, emoticons);
        
        return set.first();
    }
    
    public void DFS(int L, int[][]users, int[]emoticons) {
        if (L == emoticons.length) {
            int member = 0;
            int money = 0;
            for (int i = 0; i < users.length; i++){
                int per = users[i][0];
                int max = users[i][1];
                int sum = 0;
                for(int j = 0; j < emoticons.length; j++){
                    if (pm[j] >= per)
                        sum += emoticons[j] * (double)((100 - pm[j]) / 100.0);
                }
                if (sum >= max)
                    member++;
                else
                    money += sum;
            }
            set.add(new int[]{member, money});
        }else{
            for(int i = 0; i < 4; i++){
                pm[L] = rate[i];
                DFS(L + 1, users, emoticons);
            }
        }
        
    }
    
}