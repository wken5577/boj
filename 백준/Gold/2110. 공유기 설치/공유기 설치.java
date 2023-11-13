import java.io.*;
import java.util.*;

public class Main {
    static int n, c;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.valueOf(st.nextToken());
        c = Integer.valueOf(st.nextToken());
        arr = new int[n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.valueOf(st.nextToken());
        }
        Arrays.sort(arr);
        int lt = 1;
        int rt = arr[n - 1] - arr[0];
        int max = Integer.MIN_VALUE;

        while (lt <= rt){
            int mid = (lt + rt) / 2;
            int install = canInstall(mid);
            if (install >= c){
                max = Math.max(max, mid);
                lt = mid + 1;
            }
            else
                rt = mid - 1;
        }
        System.out.println(max);
    }

    private static int canInstall(int dis) {
        int cnt = 1;
        int last = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - last >= dis){
                cnt++;
                last = arr[i];
            }
        }

        return cnt;
    }

}
