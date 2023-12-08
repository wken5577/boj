
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int r, c;
    static int[] dx = {0, 1, 1, 1, 0, 0, 0, -1, -1, -1};
    static int[] dy = {0, -1, 0, 1, -1, 0, 1, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        try(BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
            BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in))
        ){
            StringTokenizer st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            int[] now = new int[2];
            char[][]map = new char[r][c];
            int move = 0;
            Queue<int[]> acs = new LinkedList<>();
            for(int i = 0; i < r; i++){
                String str = br.readLine();
                for(int j = 0; j < c; j++){
                    map[i][j] = str.charAt(j);
                    if (str.charAt(j) == 'I'){
                        now[0] = i;
                        now[1] = j;
                    }else if (str.charAt(j) == 'R'){
                        acs.add(new int[]{i, j});
                    }
                }
            }
            String moves = br.readLine();
            while (move < moves.length()) {
                //종수 이동
                int dir = moves.charAt(move++) - '0';
                map[now[0]][now[1]] = '.';
                int nx = now[0] + dx[dir];
                int ny = now[1] + dy[dir];
                if(map[nx][ny] == 'R'){
                    System.out.println("kraj " + move);
                    return;
                }
                map[nx][ny] = 'I';
                now[0] = nx;
                now[1] = ny;

                //미친애들 이동
                int size = acs.size();
                Map<String, Integer> moveMap = new HashMap<>();
                for (int i = 0; i < size; i++) {
                    int[] mNow = acs.poll();
                    int[] mNext = new int[2];
                    int minDis = Integer.MAX_VALUE;
                    for (int d = 1; d <= 9; d++) {
                        int mNx = mNow[0] + dx[d];
                        int mNy = mNow[1] + dy[d];
                        int dis = Math.abs(now[0] - mNx) + Math.abs(now[1] - mNy);
                        if (dis < minDis){
                            mNext[0] = mNx;
                            mNext[1] = mNy;
                            minDis = dis;
                        }
                    }
                    map[mNow[0]][mNow[1]] = '.';
                    // 종수 만나면 끝
                    if (now[0] == mNext[0] && now[1] == mNext[1]){
                        System.out.println("kraj " + move);
                        return;
                    }
                    String key = mNext[0] + "," + mNext[1];
                    moveMap.put(key, moveMap.getOrDefault(key, 0) + 1);
                    acs.add(mNext);
                }
                moveMap.keySet().forEach((key) -> {
                    if (moveMap.get(key) == 1) {
                        String[] split = key.split(",");
                        int x = Integer.parseInt(split[0]);
                        int y = Integer.parseInt(split[1]);
                        map[x][y] = 'R';
                    }
                });

                // 미친애들 폭파
                List<String> delList = moveMap.keySet().stream()
                        .filter((key) -> moveMap.get(key) >= 2).collect(Collectors.toList());
                size = acs.size();
                for (int i = 0; i < size; i++) {
                    int[] poll = acs.poll();
                    String delKey = poll[0] + "," + poll[1];
                    if (!delList.contains(delKey)){
                        acs.add(poll);
                    }else{
                        map[poll[0]][poll[1]] = '.';
                    }

                }
            }

            for (char[] chars : map) {
                for (char aChar : chars) {
                    System.out.print(aChar);
                }
                System.out.println();
            }

        }
    }

}
