import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] split = br.readLine().split(" ");
            int r = Integer.parseInt(split[0]);
            int c = Integer.parseInt(split[1]);
            int[][] map = new int[r][c];

            for (int i = 0; i < r; i++) {
                String line = br.readLine();

                for (int j = 0; j < c; j++) {
                    if (line.charAt(j) == '.') map[i][j] = 0;
                    else map[i][j] = 1;
                }
            }

            Solution solution = new Solution();
            solution.solution(r, c, map);
        }
    }
}

class Solution {
    public void solution(int r, int c, int[][] map) {
        int cnt = 0;
        for (int i = 0; i < r; i++) {
            if (DFS(r, c, i, 0, map)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public boolean DFS(int r, int c, int nowR, int nowC, int[][] map) {
        map[nowR][nowC] = 1; // 방문 처리
        if (nowC == c - 1) return true;

        boolean result;
        // 오른쪽 위
        int nc = nowC + 1;
        int nr = nowR - 1;
        if (nr >= 0 && nr < r && nc >= 0 && nc < c && map[nr][nc] == 0) {
            result = DFS(r, c, nr, nc, map);
            if (result) return true;
        }

        // 오른쪽
        nc = nowC + 1;
        nr = nowR;
        if (nr >= 0 && nr < r && nc >= 0 && nc < c && map[nr][nc] == 0) {
            result = DFS(r, c, nr, nc, map);
            if (result) return true;
        }

        // 오른쪽 아래
        nc = nowC + 1;
        nr = nowR + 1;
        if (nr >= 0 && nr < r && nc >= 0 && nc < c && map[nr][nc] == 0) {
            result = DFS(r, c, nr, nc, map);
            if (result) return true;
        }
        return false;
    }
}

