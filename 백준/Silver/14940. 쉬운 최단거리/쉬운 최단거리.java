import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());
        int[] start = new int[2];
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.valueOf(st.nextToken());
                if (num == 2){
                    start[0] = i;
                    start[1] = j;
                    map[i][j] = num;
                }else if(num == 1){
                    map[i][j] = -1;
                }else
                    map[i][j] = num;
            }
        }
         BFS(start[0], start[1]);
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static void BFS(int x, int y) {
        boolean[][] ch = new boolean[n][m];
        ch[x][y] = true;
        map[x][y] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        int l = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] now = queue.poll();
                for (int s = 0; s < 4; s++) {
                    int nx = now[0] + dx[s];
                    int ny = now[1] + dy[s];
                    if (0 <= nx &&  nx < n && 0 <= ny && ny< m && !ch[nx][ny] && map[nx][ny] == -1){
                        ch[nx][ny] = true;
                        map[nx][ny] = l;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
            l++;
        }
    }

}
