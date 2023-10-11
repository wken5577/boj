import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] dj = new int[100000 + 1];
        Arrays.fill(dj, Integer.MAX_VALUE);
        PriorityQueue<int []> pq = new PriorityQueue<>((o1 ,o2) -> o1[1] - o2[1]);
        pq.add(new int[]{n, 0});
        dj[n] = 0;
        while (!pq.isEmpty()){
            int[] now = pq.poll();
            int next = now[0] * 2;
            if (0 <= next && next <= 100000 && dj[next] > now[1]){
                dj[next] = now[1];
                pq.add(new int[]{next, now[1]});
            }
            next = now[0] + 1;
            if (0 <= next && next <= 100000 && dj[next] > now[1] + 1){
                dj[next] = now[1] + 1;
                pq.add(new int[]{next, now[1] + 1});
            }
            next = now[0] - 1;
            if (0 <= next && next <= 100000 && dj[next] > now[1] + 1){
                dj[next] = now[1] + 1;
                pq.add(new int[]{next, now[1] + 1});
            }
        }
        System.out.println(dj[k]);
    }
}