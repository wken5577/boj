import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        List<Integer> list = new LinkedList();
        int[][] map = new int[rows + 1][columns + 1];
        for(int i = 1; i <= rows; i++){
            for(int j = 1; j <= columns; j++){
                map[i][j] = (i - 1) * columns + j;
            }
        }
        for(int i = 0; i < queries.length; i++){
           int r1 = queries[i][0];
            int c1 = queries[i][1];
            int r2 = queries[i][2];
            int c2 = queries[i][3];
            
            int min = Integer.MAX_VALUE;
            int r = r1;
            int c = c1 + 1;
            int prev = map[r1][c1];
            min = Math.min(min, prev);
            while (c <= c2){
                int tmp;
                tmp = map[r][c];
                map[r][c] = prev;
                prev = tmp;
                min = Math.min(min, prev);
                c++;
            }
            c--;
            r++;
            while (r <= r2){
               int tmp;
                tmp = map[r][c];
                map[r][c] = prev;
                prev = tmp;
                min = Math.min(min, prev);
                r++;
            }
            r--;
            c--;
            while (c >= c1){
                int tmp;
                tmp = map[r][c];
                map[r][c] = prev;
                prev = tmp;
                min = Math.min(min, prev);
                c--;
            }
            c++;
            r--;
            while (r >= r1){
                int tmp;
                tmp = map[r][c];
                map[r][c] = prev;
                prev = tmp;
                min = Math.min(min, prev);
                r--;
            }
            list.add(min);
        }
        
        
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}