
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.http.HttpRequest;
import java.util.*;
import java.util.stream.Collectors;

class Main {
    static int[] map;
    static int  n, s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.valueOf(st.nextToken());
        s = Integer.valueOf(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }
        int lt = 0, rt = 0;
        int sum = arr[0];
        if (sum >= s){
            System.out.println(1);
            return;
        }
        int answer = Integer.MAX_VALUE;
        while (rt + 1 < n){
            sum += arr[++rt];
            if (sum >= s){
                while (sum >= s){
                    answer = Math.min(rt - lt + 1, answer);
                    sum -= arr[lt++];
                }
            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);

    }

}