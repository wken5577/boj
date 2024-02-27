import java.io.*;
import java.util.*;


public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            n = Integer.parseInt(br.readLine());
            long[] arr = new long[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }
            Arrays.sort(arr);
            if (n == 3){
                for (long i : arr) {
                    System.out.print(i + " ");
                }
                return;
            }

            List<Long> ans = new ArrayList<>();
            long minDis = Long.MAX_VALUE;
            for (int mid = 0; mid < n; mid++) {
                int lt = 0, rt = n - 1;
                while (lt < rt){
                    if (lt == mid){
                        lt++;
                        continue;
                    }
                    if (rt == mid){
                        rt--;
                        continue;
                    }
                    long sum = arr[lt] + arr[rt] + arr[mid];
                    if (Math.abs(sum) < minDis){
                        minDis = Math.abs(sum);
                        ans.clear();
                        ans.add(arr[lt]);
                        ans.add(arr[rt]);
                        ans.add(arr[mid]);
                    }
                    if (minDis == 0)
                        break;
                    if (sum < 0)
                        lt++;
                    else
                        rt--;
                }
                if(minDis == 0)
                    break;
            }

            ans.sort(Comparator.comparingLong(o1 -> o1));
            for (Long an : ans) {
                System.out.print(an + " ");
            }

        }

    }


}