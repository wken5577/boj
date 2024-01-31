import java.io.*;
import java.util.*;

public class Main {
    static int a, b, c;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
             a = Integer.parseInt(st.nextToken());
             b = Integer.parseInt(st.nextToken());
             c = Integer.parseInt(st.nextToken());

            System.out.println(pow(a, b));
        }
    }

    public static long pow(long base, long e){
        if (e == 1)
            return base % c;

        long tmp = pow(base, e / 2);

        if (e % 2 == 0) {
            return tmp * tmp % c;
        }

        // (tmp * tmp * base) % c = ((tmp * tmp % c) * (base % c)) % c
        return ((tmp * tmp % c) * (base % c)) % c;
    }

}
