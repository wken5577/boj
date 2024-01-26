import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int[][] map = new int[n][n];
            int[] shark = new int[2];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 9) {
                        shark[0] = i; shark[1] = j;
                    }
                }
            }

            int time = 0;
            int size = 2;
            int eatCount = 0;
            while (true) {
                List<int[]> fishPoint = new ArrayList<>();
                boolean[][] ch = new boolean[n][n];
                ch[shark[0]][shark[1]] = true;
                searchFish(size, fishPoint, map, ch, shark[0], shark[1]);
                if (fishPoint.size() == 0)
                    break;
                List<int[]> nearBy = new ArrayList<>();
                int disMin = Integer.MAX_VALUE;
                for (int[] fish : fishPoint) {
                    int dis = calcDis(fish, shark, map, size);
                    if (dis < disMin){
                        nearBy.clear();
                        nearBy.add(fish);
                        disMin = dis;
                    } else if (dis == disMin) {
                        nearBy.add(fish);
                    }
                }
                nearBy.sort(((o1, o2) -> {
                    if (o1[0] == o2[0])
                        return o1[1] - o2[1];
                    return o1[0] - o2[0];
                }));

                int[] target = nearBy.get(0);
                time += disMin;
                map[target[0]][target[1]] = 0;
                map[shark[0]][shark[1]] = 0;
                shark = target;
                eatCount++;
                if (size == eatCount){
                    eatCount = 0;
                    size++;
                }
            }
            System.out.println(time);
        }
    }

    private static int calcDis(int[] target, int[] shark, int[][] map, int size) {
        int[][] dj = new int[n][n];
        int[] point = new int[3];
        point[0] = shark[0];
        point[1] = shark[1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dj[i], Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o1 -> o1[2]));
        pq.add(point);
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];
                if (0 <= nx && nx < n && 0 <= ny && ny < n && map[nx][ny] <= size) {
                    if (now[2] + 1< dj[nx][ny]){
                        dj[nx][ny] = now[2] + 1;
                        pq.add(new int[] {nx, ny, now[2] + 1});
                    }
                }
            }

        }
        return dj[target[0]][target[1]];
    }

    private static void searchFish(int size, List<int[]> fishPoint, int[][] map, boolean[][] ch, int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (0 <= nx && nx < n && 0 <= ny && ny < n && !ch[nx][ny] && map[nx][ny] <= size) {
                if (map[nx][ny] < size && map[nx][ny] != 0)
                    fishPoint.add(new int[]{nx, ny});
                ch[nx][ny] = true;
                searchFish(size, fishPoint, map, ch, nx, ny);
            }
        }
    }

}
