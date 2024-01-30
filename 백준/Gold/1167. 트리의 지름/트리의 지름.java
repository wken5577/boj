import java.io.*;
import java.util.*;

public class Main {
    static int v;
    static int max, node;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer st;
            Scanner sc = new Scanner(System.in);
            v = sc.nextInt();
            List<List<int[]>> list = new ArrayList<>();
            for (int i = 0; i <= v; i++) {
                list.add(new ArrayList<>());
            }
            
            for (int i = 0; i < v; i++) {
                int s = sc.nextInt();
                List<int[]> integerList = list.get(s);
                while (true){
                    int e = sc.nextInt();
                    if (e == -1)
                        break;
                    int d = sc.nextInt();
                    integerList.add(new int[] {e, d});
                }
            }

            boolean[] visit = new boolean[v + 1];
            // visit[1] = true;
            dfs(list, 1, 0, visit);

            visit = new boolean[v + 1];
            // visit[node] = true;
            dfs(list, node, 0, visit);

            System.out.println(max);
        }
    }

    private static void dfs(List<List<int[]>> list, int s, int len, boolean[] visit) {
        if (len > max){
            max = len;
            node = s;
        }
        visit[s] = true;
        List<int[]> nexts = list.get(s);
        for (int[] next : nexts) {
            if (!visit[next[0]]){
                visit[next[0]] = true;
                dfs(list, next[0], next[1] + len, visit);
            }
        }
    }

}
