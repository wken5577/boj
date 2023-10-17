import java.io.*;
import java.util.*;

class Main {
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.valueOf(st.nextToken());
        k = Integer.valueOf(st.nextToken());

        int[] count = new int[100001];
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }

        int lt = 0;
        int rt = 0;
        int answer = 0;
        while (rt < n) {
            if (count[arr[rt]] != k){
                count[arr[rt]]++;
                rt++;
            }else{
                count[arr[lt]]--;
                lt++;
            }
            answer = Math.max(answer, rt - lt);
        }
        System.out.println(answer);

    }
}