import java.io.*;
import java.util.*;

class Main {
    static List<int[]> list = new ArrayList<>();
    static int n, m, k, l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(br.readLine());
         n = Integer.valueOf(st.nextToken()); //가로
         m = Integer.valueOf(st.nextToken()); //세로
         l = Integer.valueOf(st.nextToken());
         k = Integer.valueOf(st.nextToken());

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.valueOf(st.nextToken());
            int y = Integer.valueOf(st.nextToken());
            list.add(new int[]{x, y});
        }
        int max = Integer.MIN_VALUE;

        for (int[] s1 : list){
            for (int[] s2 : list){
                max = Math.max(max, count(s1[0], s2[1]));
            }
        }
        System.out.println(k - max);
    }

    static int count(int i, int j){
        int cnt = 0;

        for(int[] star : list){
            if (i <= star[0] && star[0] <= i + l &&
            j <= star[1] && star[1] <= j + l)
                cnt++;
        }
        return cnt;
    }
}