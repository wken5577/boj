import java.io.*;
import java.util.*;

import static java.lang.System.exit;

public class Main {
    static int n, m;
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] data = new int[m + 1][3];
        LinkedList<Integer> [][] map = new LinkedList[n + 1][n + 1];
        int[][] board = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = new LinkedList<>();
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            data[i][0] = Integer.parseInt(st.nextToken());
            data[i][1] = Integer.parseInt(st.nextToken());
            data[i][2] = Integer.parseInt(st.nextToken());
            map[data[i][0]][data[i][1]].add(i);
        }
        int cnt = 1;
        while (cnt <= 1000){
            for (int i = 1; i <= m; i++) {
                int nx = data[i][0] + dx[data[i][2]];
                int ny = data[i][1] + dy[data[i][2]];
                if (nx < 1 || nx > n || ny < 1 || ny > n || board[nx][ny] == 2) {
                    int dir = moveDir(data[i][2]);
                    nx = data[i][0] + dx[dir];
                    ny = data[i][1] + dy[dir];
                    data[i][2] = dir;
                    if (nx < 1 || nx > n || ny < 1 || ny > n || board[nx][ny] == 2)
                        continue;
                }
                if (board[nx][ny] == 1){
                    if (moveRevOrder(data, map, nx, ny, i)){
                        System.out.println(cnt);
                        return;
                    }
                } else if (board[nx][ny] == 0) {
                    if (moveOrder(data, map, nx, ny, i)) {
                        System.out.println(cnt);
                        return;
                    }
                }
            }
//            System.out.println("=============== data =================");
//            for (int t = 1; t < data.length; t++) {
//                System.out.println(t - 1 + " x = " + data[t][0] + " y = " + data[t][1] + " dir = " + data[t][2]);
//            }
//            Set<Map.Entry<String, LinkedList<Integer>>> entries = hash.entrySet();
//            for (Map.Entry<String, LinkedList<Integer>> entry : entries) {
//                LinkedList<Integer> integers = hash.get(entry.getKey());
//                if (integers.size() > 0){
//                    System.out.println("key = " + entry.getKey());
//                    for (Integer integer : integers) {
//                        System.out.print(integer - 1+ " ");
//                    }
//                    System.out.println();
//                }
//            }
            cnt++;
        }
        System.out.println(-1);
    }

    private static boolean moveOrder(int[][] data, LinkedList<Integer>[][] map, int nx, int ny, int i) {
        LinkedList<Integer> nowList = map[data[i][0]][data[i][1]];
        int idx = findIdx(nowList, i);
        LinkedList<Integer> nextList = map[nx][ny];
        for (int s = idx; s < nowList.size(); s++) {
            int tar = nowList.get(s);
            data[tar][0] = nx;
            data[tar][1] = ny;
            nextList.add(nowList.get(s));
        }
        int numDel = nowList.size() - idx;
        for (int s = 0; s < numDel; s++) {
            nowList.removeLast();
        }
        if (nextList.size() >= 4){
            return true;
        }

        return false;
    }

    private static boolean moveRevOrder(int[][] data, LinkedList<Integer>[][] map, int nx, int ny, int i) {
        LinkedList<Integer> nowList = map[data[i][0]][data[i][1]];
        int idx = findIdx(nowList, i);
        LinkedList<Integer> nextList = map[nx][ny];
        for (int s = nowList.size() - 1; s >= idx; s--) {
            int tar = nowList.get(s);
            data[tar][0] = nx;
            data[tar][1] = ny;
            nextList.add(nowList.get(s));
        }
        int numDel = nowList.size() - idx;
        for (int s = 0; s < numDel; s++) {
            nowList.removeLast();
        }
        if (nextList.size() >= 4){
            return true;
        }
        return false;
    }

    private static int findIdx(LinkedList<Integer> nowList, int tar) {
        for (int i = 0; i < nowList.size(); i++) {
            if (nowList.get(i) == tar)
                return i;
        }
        return -1;
    }

    private static int moveDir(int i) {
        switch (i){
            case 1:
                return 2;
            case 2:
                return 1;
            case 3:
                return 4;
            case 4:
                return 3;
        }
        return -1;
    }
}
