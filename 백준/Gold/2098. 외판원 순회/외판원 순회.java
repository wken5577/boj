import java.io.*;
import java.util.*;

class Main {
    static int maxBit;
    static int n;
    static int[][] map;
    static int[][] dy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        Scanner sc = new Scanner(System.in);
        n = Integer.valueOf(br.readLine());
        maxBit = (1 << n) - 1;
        map = new int[n + 1][n + 1];
        dy = new int[n + 1][1 << n];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dy[i], -1);
        }
        int answer = DFS(1, 1);
        System.out.println(answer);
    }

    private static int DFS(int now, int bit) {
        if ((bit & maxBit) == maxBit){
            if (map[now][1] != 0){
                return map[now][1];
            }
            return Integer.MAX_VALUE;
        }
        if (dy[now][bit] != -1)
            return dy[now][bit];
        dy[now][bit] = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            if (map[now][i] != 0){
                int tmp =  1 << i - 1;
                if ((bit & tmp) != tmp){
                    int result = DFS(i, bit | tmp);
                    if (result != Integer.MAX_VALUE)
                        dy[now][bit] = Math.min(dy[now][bit], result + map[now][i]);
                }
            }
        }
        return dy[now][bit];
    }

}