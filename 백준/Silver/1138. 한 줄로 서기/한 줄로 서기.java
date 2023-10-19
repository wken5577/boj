import java.io.*;
import java.util.*;

class Main {

    static int n;
    static int[] pm, arr;
    static boolean[] ch;
    static boolean fin = false;
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
//        StringTokenizer st = new StringTokenizer(br.readLine());

        n = sc.nextInt();
        arr = new int[n + 1];
        ch = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        pm = new int[n + 1];

        DFS(1);
    }

    private static void DFS(int l) {
        if (fin)
            return;
        if (l == n + 1){
            for (int i = 1; i <= n; i++) {
                int cnt = 0;
                for (int j = i - 1; j >= 1; j--) {
                    if (pm[j]> pm[i])
                        cnt++;
                }
                if (cnt != arr[pm[i]])
                    return;
            }
            fin = true;
            for (int i = 1; i <= n; i++) {
                System.out.print(pm[i] + " ");
            }
            System.out.println();
        }else{
            for (int i = 1; i <= n; i++) {
                if (!ch[i]){
                    pm[l] = i;
                    ch[i] = true;
                    DFS(l + 1);
                    ch[i] = false;
                }
            }
        }
    }
}