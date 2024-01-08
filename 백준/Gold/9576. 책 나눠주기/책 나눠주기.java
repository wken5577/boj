import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ){
            int t = Integer.parseInt(br.readLine());
            for (int i = 0; i < t; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());
                boolean[] ch = new boolean[n + 1];
                boolean[] ch1 = new boolean[n + 1];
                List<int[]> list = new ArrayList<>();
                int ans = 0;
                for (int j = 0; j < m; j++) {
                    st = new StringTokenizer(br.readLine());
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    list.add(new int[]{a, b, b - a});
                }
                Collections.sort(list, Comparator.comparingInt(o -> o[1]));
                for (int[] ints : list) {
                    int start = ints[0];
                    int end = ints[1];
                    for(int s = start; s <= end; s++){
                        if (!ch[s]){
                            ch[s] = true;
                            ans++;
                            break;
                        }
                    }
                }

                System.out.println(ans);
            }


        }

    }


}