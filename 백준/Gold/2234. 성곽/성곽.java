import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int roomCnt = 0, maxArea = 0, maxAreaDelOne = 0, areaCnt = 0;
    static int dx[] = {0, -1, 0, 1};
    static int dy[] = {-1, 0, 1, 0};
    static int dir[] = {1, 2, 4, 8};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int [][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean chArea[][] = new boolean[n][m];
        boolean myArea[][];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!chArea[i][j]){
                    roomCnt++;
                    areaCnt = 0;
                    myArea = new boolean[n][m];
                    searchArea(chArea, myArea, map, i, j);
                    maxArea = Math.max(maxArea, areaCnt);
                    searchDelArea(myArea, map, areaCnt);
                }
            }
        }
        System.out.println(roomCnt);
        System.out.println(maxArea);
        System.out.println(maxAreaDelOne);
    }

    private static void searchDelArea(boolean[][] myArea, int[][] map, int prev) {
        boolean[][] areaNear = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (myArea[i][j]){
                    deleteWall(i, j, myArea, map, areaNear, prev);
                }
            }
        }
//        System.out.println(" ======== my area ======= ");
//        for (boolean[] booleans : myArea) {
//            for (boolean aBoolean : booleans) {
//                System.out.print(aBoolean + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//        System.out.println(" ======== area near ======= ");
//        for (boolean[] booleans : areaNear) {
//            for (boolean aBoolean : booleans) {
//                System.out.print(aBoolean + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
    }

    private static void deleteWall(int x, int y, boolean[][] myArea, int[][] map, boolean[][] areaNear, int prev) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < n && 0 <= ny && ny < m && !myArea[nx][ny] && !areaNear[nx][ny]){
                if (checkIsWall(dir[i], map[x][y])){
                    areaCnt = 0;
                    searchArea(areaNear, areaNear, map, nx, ny);
                    maxAreaDelOne = Math.max(maxAreaDelOne, prev + areaCnt);
                }
            }
        }
    }

    private static void searchArea(boolean[][] chArea, boolean[][] myArea, int[][] map, int x, int y) {
        chArea[x][y] = true;
        myArea[x][y] = true;
        areaCnt++;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < n && 0 <= ny && ny < m && !chArea[nx][ny]){
                if (!checkIsWall(dir[i], map[x][y])){
                    searchArea(chArea, myArea, map, nx, ny);
                }
            }
        }
    }

    private static boolean checkIsWall(int dir, int data) {
        return (dir & data) == dir;
    }

}
