
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.http.HttpRequest;
import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        Scanner sc = new Scanner(System.in);
//        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<int[]> stack = new Stack<>();
        int n = Integer.valueOf(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }

        List<Integer> list = new ArrayList<>();

        list.add(0);
        stack.add(new int[]{1, arr[1]});

        for (int i = 2; i <= n; i++) {
            boolean flag = false;
            while (!stack.isEmpty()){
                int[] top = stack.peek();
                if (arr[i] > top[1])
                    stack.pop();
                else{
                    stack.add(new int[]{i, arr[i]});
                    list.add(top[0]);
                    flag = true;
                    break;
                }
            }
            if(!flag){
                list.add(0);
                stack.add(new int[]{i, arr[i]});
            }
        }

        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        System.out.println();

    }

}