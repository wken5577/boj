import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            // StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            int[] lis = new int[n];
            int size = 0;
            for (int i = 0; i < n; i++) {
                if (i == 0)
                    lis[size++] = arr[i];
                else{
                    if (lis[size - 1] < arr[i]){
                        lis[size++] = arr[i];
                    }else{
                        int target = Arrays.binarySearch(lis, 0, size - 1, arr[i]);
                        target *= -1;
                        target -= 1;
                        lis[target] = arr[i];
                    }
                }
            }
            System.out.println(n - size);


        }
    }

}
