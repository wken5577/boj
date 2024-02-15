
import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            List<int[]> gems = new ArrayList<>();
            List<Integer> bags = new ArrayList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int m = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                gems.add(new int[]{m, v});
            }
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                bags.add(Integer.parseInt(st.nextToken()));
            }
            gems.sort(Comparator.comparingInt(o1 -> o1[0]));
            bags.sort(Comparator.comparingInt(o1 -> o1));

            long answer = 0;
            int bagIdx = 0;
            int gemIdx = 0;
            while (bagIdx < k && gemIdx < n) {
                int[] gem = gems.get(gemIdx);
                int m = gem[0];
                int v = gem[1];
                int c = bags.get(bagIdx);
                // 보석의 무게가 가방보다 클때
                if (m > c){
                    bagIdx++;
                    if (!pq.isEmpty())
                        answer += pq.poll();
                }
                else{
                    //보석이 가방에 들어갈 수 있을 때
                    pq.add(v);
                    gemIdx++;
                }
            }

            while (bagIdx < k && !pq.isEmpty()){
                answer += pq.poll();
                bagIdx++;
            }

            System.out.println(answer);
        }
    }
}