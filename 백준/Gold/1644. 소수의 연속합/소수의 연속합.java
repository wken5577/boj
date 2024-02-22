import java.io.*;
import java.util.*;
import java.util.spi.AbstractResourceBundleProvider;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            List<Integer> primes = new ArrayList<>();
            int[] arr = new int[n + 1];
            for (int i = 2; i <= n; i++) {
                if (arr[i] == 0){
                    primes.add(i);
                    int tmp = i;
                    while (tmp <= n){
                        arr[tmp] = 1;
                        tmp += i;
                    }
                }
            }
            if (primes.size() == 0){
                System.out.println(0);
                return;
            }
            int lt = 0, rt = 1;
            int sum = primes.get(lt);
            int cnt = 0;
            while (lt <= rt){
                if (sum == n){
                    cnt++;
                    if (rt == primes.size()) break;
                    sum += primes.get(rt++);
                }else if(sum < n){
                    if (rt == primes.size()) break;
                    sum += primes.get(rt++);
                }else{
                    if (lt == primes.size()) break;
                    sum -= primes.get(lt++);
                }
            }
            System.out.println(cnt);
        }
    }

}