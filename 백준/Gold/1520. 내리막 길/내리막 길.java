import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] board, dp;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n + 1][m + 1];
        dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String str1 = br.readLine();
            st = new StringTokenizer(str1, " ");
            for (int j = 1; j <= m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(DFS(1,1));
    }

    private static int DFS(int x, int y) {
        if(dp[x][y] != -1) return dp[x][y];
        if(x == n && y ==m){
            return 1;
        }
        else{
            dp[x][y] = 0;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (1 <= nx && nx <= n && 1 <= ny && ny <= m &&  board[x][y] > board[nx][ny]) {
                    dp[x][y] += DFS(nx, ny);
                }
            }
        }
        return dp[x][y];
    }

}