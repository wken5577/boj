import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String str = sc.nextLine();
        char[] chars = str.toCharArray();
        int windowSize = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'a')
                windowSize++;
        }
        int cntB = 0;
        for (int i = 0; i < windowSize; i++) {
            if (chars[i] == 'b')
                cntB++;
        }
        int min = cntB;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] == 'b')
                cntB--;
            int last = (i + windowSize) % chars.length - 1;
            if (last == -1)
                last = chars.length - 1;
            if (chars[last] == 'b')
                cntB++;
            min = Math.min(min, cntB);
        }
        System.out.println(min);

    }
}