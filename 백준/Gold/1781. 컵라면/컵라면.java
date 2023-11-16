import java.io.*;
import java.util.*;

import static java.lang.System.exit;

public class Main {
    static int n, l;
    static String[] strArr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
//        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(st.nextToken());
        List<int[]> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new int[]{d, c});
        }
        Collections.sort(list, (o1, o2) -> {
            if (o1[0] == o2[0])
                return o2[1] - o1[1];
            return o1[0] - o2[0];
        });

        int answer = 0;
        for (int[] data : list) {
            if (pq.size() >= data[0]){
                int peek = pq.peek();
                if (peek < data[1]){
                    pq.poll();
                    pq.add(data[1]);
                }
            }else{
                pq.add(data[1]);
            }
        }
        for(Integer a : pq){
            answer += a;
        }
        System.out.println(answer);
    }

}
