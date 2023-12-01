import java.io.*;
import java.util.*;

import static java.lang.System.exit;

public class Main {
    static int n, m;
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < n; k++) { // 경유노드
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
        boolean ch[] = new boolean[n];
        DFS(m, ch, map, 0, 0);
        System.out.println(answer);
    }

    private static void DFS(int now, boolean[] ch, int[][] map, int L, int cost) {
        if (cost > answer)
            return;
        if (L == n){
            answer = Math.min(answer, cost);
        }else{
            for (int i = 0; i < n; i++) {
                if (ch[i]) continue;
                ch[i] = true;
                DFS(i, ch, map, L + 1, cost + map[now][i]);
                ch[i] = false;
            }
        }
    }
}
