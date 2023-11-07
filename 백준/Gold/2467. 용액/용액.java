import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.valueOf(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }
        int lt = 0, rt = n - 1;
        int z = Integer.MAX_VALUE;
        int[] answer = new int[2];
        while (lt < rt){
            int tmp = arr[lt] + arr[rt];
            int a = Math.abs(z);
            int b = Math.abs(tmp);
            if (a >= b){
                z = b;
                answer[0] = arr[lt];
                answer[1] = arr[rt];
            }
            if (tmp > 0)
                rt--;
            else
                lt++;
        }
        System.out.println(answer[0] + " " + answer[1]);

    }



}
