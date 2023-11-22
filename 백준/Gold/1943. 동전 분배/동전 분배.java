import java.io.*;
import java.util.*;

import static java.lang.System.exit;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            List<int[]> list = new ArrayList<>();
            int sum = 0;
            for (int s = 0; s < n; s++) {
                st = new StringTokenizer(br.readLine());
                int coin = Integer.parseInt(st.nextToken());
                int amount = Integer.parseInt(st.nextToken());
                sum += coin * amount;
                list.add(new int[] {coin, amount});
            }
            if (sum % 2 != 0){
                System.out.println(0);
                continue;
            }
            int mid = sum / 2;
            boolean dy[] = new boolean[mid + 1];
            dy[0] = true;
            for (int[] data : list) {
                for (int s = mid; s >= data[0]; s--) {
                    if (dy[s - data[0]]){
                        for (int t = 0; t < data[1]; t++) {
                            if (s + t * data[0] <= mid){
                                dy[s + t * data[0]] = true;
                            }else
                                break;
                        }
                    }
                }

            }
            if (dy[mid])
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}
