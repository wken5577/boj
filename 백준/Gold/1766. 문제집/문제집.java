import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] indegree = new int[n + 1];
            ArrayList<Integer>[] list = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                list[s].add(e);
                indegree[e]++;
            }

            int idx = 1;
            List<Integer> ans = new ArrayList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            while (idx <= n) {
                if (indegree[idx] == 0){
                    int top = pq.isEmpty() ? Integer.MAX_VALUE : pq.peek();
                    if (top < idx){
                        int target = pq.poll();
                        ans.add(target);
                        decreseIndegree(pq, list, target, indegree);
                    }
                    else if (top == idx){
                        ans.add(pq.poll());
                        decreseIndegree(pq, list, idx, indegree);
                        idx++;
                    } else{
                        decreseIndegree(pq, list, idx, indegree);
                        ans.add(idx++);
                    }
                }else{
                    int top = pq.isEmpty() ? Integer.MAX_VALUE : pq.peek();
                    if (top < idx){
                        int target = pq.poll();
                        ans.add(target);
                        decreseIndegree(pq, list, target, indegree);
                    }
                    else
                        idx++;
                }
            }
            while(!pq.isEmpty()){
                int target = pq.poll();
                ans.add(target);
                decreseIndegree(pq, list, target, indegree);
            }

            for (Integer an : ans) {
                System.out.print(an + " ");
            }
        }
    }

    private static void decreseIndegree(PriorityQueue<Integer> pq, ArrayList<Integer>[] list,
        int target, int[] indegree) {
        for (Integer integer : list[target]) {
            indegree[integer]--;
            if (indegree[integer] == 0)
                pq.add(integer);
        }
    }

}