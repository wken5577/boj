import java.io.*;
import java.util.*;

public class Main {
    static int n, m, x, y, k;
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};
    static int[] dicePoint = new int[2];

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            dicePoint[0] = x;
            dicePoint[1] = y;
            int[][] map = new int[n][m];
            int[] dice = new int[6];
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < m; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < k; i++) {
                int dir = Integer.parseInt(st.nextToken());
                moveDice(map, dice, dir);
            }
        }
    }

    private static void moveDice(int[][] map, int[] dice, int dir) {
        int[] now = new int[] {dicePoint[0], dicePoint[1]};
        int nx = dx[dir] + now[0];
        int ny = dy[dir] + now[1];

        if (0 <= nx && nx < n && 0 <= ny && ny < m){
            // 주사위 굴리기
            rollDice(dice, dir);
            if (map[nx][ny] == 0){
                map[nx][ny] = dice[5];
            }else{
                dice[5] = map[nx][ny];
                map[nx][ny] = 0;
            }
            dicePoint[0] = nx;
            dicePoint[1] = ny;
            System.out.println(dice[0]);
        }
    }

    private static void rollDice(int[] dice, int dir) {
        int[] diceCopy = Arrays.copyOf(dice, 6);
        if (dir == 1){
            dice[0] = diceCopy[3];
            dice[2] = diceCopy[0];
            dice[3] = diceCopy[5];
            dice[5] = diceCopy[2];
        }else if (dir == 2){
            dice[0] = diceCopy[2];
            dice[2] = diceCopy[5];
            dice[3] = diceCopy[0];
            dice[5] = diceCopy[3];
        }else if (dir == 3){
            dice[1] = diceCopy[0];
            dice[0] = diceCopy[4];
            dice[4] = diceCopy[5];
            dice[5] = diceCopy[1];
        }else{
            dice[1] = diceCopy[5];
            dice[0] = diceCopy[1];
            dice[4] = diceCopy[0];
            dice[5] = diceCopy[4];
        }

    }

}
