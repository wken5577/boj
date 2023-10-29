
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.http.HttpRequest;
import java.util.*;
import java.util.stream.Collectors;

class Main {
    static int[] map;
    static int h, w;
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;
         h = sc.nextInt();
         w = sc.nextInt();
        map = new int[w];

        for (int i = 0; i < w; i++) {
            map[i] = sc.nextInt();
        }

        int lm = map[0];
        for (int i = 1; i < w - 1; i++) {
            int rm = Integer.MIN_VALUE;
            for (int j = i + 1; j < w; j++) {
                rm = Math.max(map[j], rm);
            }
            if (lm > map[i] && rm > map[i]){
                int height = Math.min(lm, rm);
                answer += height - map[i];
            }
            lm = Math.max(lm, map[i]);
        }

        System.out.println(answer);
    }

}