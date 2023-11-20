import java.io.*;
import java.util.*;

import static java.lang.System.exit;

public class Main {
    static int n, target, rest;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
//        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(st.nextToken());
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int dis = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.add(new int[] {dis, cost});
        }
        st = new StringTokenizer(br.readLine());
        target = Integer.parseInt(st.nextToken());
        rest = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o2[1] - o1[1];
        });
        list.sort((o1, o2) -> {
            return o1[0] - o2[0];
        });
        int cnt = 0;
        int i = 0;
        while (i < list.size()) {
            if (rest >= target){
                System.out.println(cnt);
                return;
            }
            while(i < list.size() && list.get(i)[0] <= rest)
                pq.add(list.get(i++));
            if (pq.isEmpty()){
                System.out.println(-1);
                return;
            }
            int[] poll = pq.poll();
            rest += poll[1];
            cnt++;
        }

        while (!pq.isEmpty()){
            if (rest >= target){
                System.out.println(cnt);
                return;
            }
            int[] poll = pq.poll();
            rest += poll[1];
            cnt++;
        }
        System.out.println(-1);

    }

}
