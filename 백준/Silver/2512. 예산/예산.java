
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        int lt = 1, rt;
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        Arrays.sort(arr);
        rt = arr[n - 1];
        int answer = 0;
        while (lt <= rt){
            int target = (lt + rt) / 2;
            if (validation(target, arr, m)){
                answer = target;
                lt = target + 1;
            }
            else
                rt = target - 1;
        }
        System.out.println(answer);
    }

    private static boolean validation(int target, int[] arr, int m) {
        int sum = 0;
        for (int num : arr) {
            if (num > target)
                sum += target;
            else
                sum += num;
            if (sum > m)
                return false;
        }
        return true;
    }
}