import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.valueOf(st.nextToken());
        int x = Integer.valueOf(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }
        int max = 0;
        int sum = 0;
        int cnt = 1;
        for (int i = 0; i < x; i++) {
            max += arr[i];
            sum += arr[i];
        }
        for (int i = x; i < n; i++) {
            sum = sum - arr[i - x] + arr[i];
            if (sum == max)
                cnt++;
            else{
                if (max < sum){
                    cnt = 1;
                    max = sum;
                }
            }
        }
        if (max == 0){
            System.out.println("SAD");
        }else{
            System.out.println(max);
            System.out.println(cnt);
        }
    }

}