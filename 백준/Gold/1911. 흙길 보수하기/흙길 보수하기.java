import java.io.*;
import java.util.*;

import static java.lang.System.exit;

public class Main {
    static int n, l;
    static String[] strArr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken()) - 1;
            list.add(new int[] {s, e});
        }
        Collections.sort(list, (o1, o2) -> o1[0] - o2[0]);
        int last = 0;
        int cnt = 0;
        for (int[] point : list) {
            int s = point[0];
            int e = point[1];

            if (last < s){
                last = s + l - 1;
                cnt++;
            }
            while (last < e){
                last += l;
                cnt++;
            }
        }
        System.out.println(cnt);
    }

}
