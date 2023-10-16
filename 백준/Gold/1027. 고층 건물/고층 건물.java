import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            //move left
            int count = 0;
            int j = i - 1;
            double tmp = 0;
            while (0 <= j){
                double slope = (double) (arr[i] - arr[j]) / (i - j);
                if (j == i - 1 || slope < tmp){
                    count++;
                    tmp = slope;
                }
               j--;
            }

            j = i + 1;
            while (j < n) {
                double slope = (double) (arr[i] - arr[j]) / (i - j);
                if (j == i + 1 || slope > tmp){
                    count++;
                    tmp = slope;
                }
                j++;
            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }
}