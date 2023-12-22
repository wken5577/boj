import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            List<int[]> list = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int[] arr = new int[3];
                arr[0] = Integer.parseInt(st.nextToken());
                arr[1] = Integer.parseInt(st.nextToken());
                arr[2] = i;
                list.add(arr);
            }
            list.sort(Comparator.comparingInt(o -> o[1]));

            int[] size = new int[200001];
            int[] ans = new int[n];
            int[] first = list.get(0);
            int max = first[1];
            size[first[0]] += first[1];
            Map<Integer, Integer> tmpMap = new HashMap<>();
            int tmp = first[1];
            tmpMap.put(first[0], first[1]);
            for (int i = 1; i < n; i++) {
                int[] prev = list.get(i - 1);
                int[] now = list.get(i);
                if (now[1] > prev[1]){
                    ans[now[2]] = max - size[now[0]];
                    tmpMap.clear();
                    tmpMap.put(now[0], now[1]);
                    tmp = now[1];
                } else if (now[1] == prev[1]){
                    int val = tmpMap.getOrDefault(now[0], 0);
                    int d = size[now[0]] - val;
                    ans[now[2]] = max - tmp - d;
                    tmp += now[1];
                    tmpMap.put(now[0], val + now[1]);
                }
                size[now[0]] += now[1];
                max += now[1];
            }
            for (int an : ans) {
                System.out.println(an);
            }
        }



    }



}
