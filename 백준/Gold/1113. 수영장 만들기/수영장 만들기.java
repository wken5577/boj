import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean valid;
    static int answer = 0, areaHeight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        boolean[][] ch = new boolean[n][m];
        boolean[][] validArea = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!ch[i][j]){
                    valid = true;
                    boolean[][] area = new boolean[n][m];
                    searchArea(ch, map, i, j, area, map[i][j]);
                    if (valid){
                        mergeValidArea(validArea, area, ch);
                    }
                }
            }
        }

        boolean[][] areaCh = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (validArea[i][j] && !areaCh[i][j]){
                    boolean[][] checkHeight = new boolean[n][m];
                    areaHeight = Integer.MAX_VALUE;
                    searchAreaHeight(validArea, i, j, map, checkHeight);
                    countArea(validArea, areaCh, i, j, map);
                }
            }
        }
        System.out.println(answer);
    }

    private static void mergeValidArea(boolean[][] validArea, boolean[][] area, boolean[][] ch) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (area[i][j]){
                    validArea[i][j] = true;
                    ch[i][j] = true;
                }
            }
        }
    }

    private static void searchAreaHeight(boolean[][] area, int x, int y, int[][] map, boolean[][] checkHeight) {
        checkHeight[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (!area[nx][ny]){
                areaHeight = Math.min(map[nx][ny], areaHeight);
            }else if (!checkHeight[nx][ny])
                searchAreaHeight(area, nx, ny, map, checkHeight);
        }

    }

    private static void countArea(boolean[][] area, boolean[][] ch, int x, int y, int[][] map) {
        ch[x][y] = true;
        answer += areaHeight - map[x][y];
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (0 <= nx && nx < n && 0 <= ny && ny < m && area[nx][ny] && !ch[nx][ny]){
                countArea(area, ch, nx, ny, map);
            }
        }
    }

    private static void searchArea(boolean[][] ch, int[][] map, int x, int y, boolean[][] area, int max) {
        area[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                valid = false;
            else if (map[nx][ny] <= max && !area[nx][ny]){
                searchArea(ch, map, nx, ny, area, Math.max(map[x][y], max));
            }
        }
    }
}
