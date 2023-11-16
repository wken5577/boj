import java.io.*;
import java.util.*;

import static java.lang.System.exit;

public class Main {
    static int n, l;
    static String[] strArr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
//        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        //보이는 것만 담을 스택
        Stack<int[]> stack = new Stack<>();
        List<int[]> answer = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            answer.add(new int[] {0, 0});
        }

        //왼쪽에서 오른쪽으로 순회하면서 오른쪽으로 보이는 건물 탐색
        stack.add(new int[]{1, arr[1]});
        for (int i = 2; i <= n; i++) {
            int[] my = answer.get(i);

            // 더 큰것만 볼 수 있기 때문에 기존에 스택에 있던 자신보다 작거나 같은 건물들 pop, \
            // 자신보다 큰 건물이 나오면 stop,이후에 건물이 자신보다 작다면 stack에있는 모든 건물을 볼 수 있다
            // 이후 스택을 순회하면서 볼 수 있는 건물 list에 추가
            while (!stack.isEmpty()){
                int[] peek = stack.peek();
                if (peek[1] <= arr[i]){
                    stack.pop();
                }else
                    break;
            }

            if (!stack.isEmpty()){
                int[] peek = stack.peek();
                my[1] = peek[0];
            }
            my[0] += stack.size();
            stack.add(new int[]{i, arr[i]});
        }

        stack.clear();

        //오른쪽에서 왼쪽으로 순회
        stack.add(new int[]{n, arr[n]});
        for (int i = n - 1; i >= 1; i--) {
            int[] my = answer.get(i);

            // 더 큰것만 볼 수 있기 때문에 기존에 스택에 있던 자신보다 작거나 같은 건물들 pop, \
            // 자신보다 큰 건물이 나오면 stop,이후에 건물이 자신보다 작다면 stack에있는 모든 건물을 볼 수 있다
            // 이후 스택을 순회하면서 볼 수 있는 건물 list에 추가
            while (!stack.isEmpty()){
                int[] peek = stack.peek();
                if (peek[1] <= arr[i]){
                    stack.pop();
                }else
                    break;
            }


            if (!stack.isEmpty()){
                int[] peek = stack.peek();
                if (my[0] == 0)
                    my[1] = peek[0];
                else{
                    int prevdis = Math.abs(i - my[1]);
                    int nowdis =  Math.abs(i - peek[0]);
                    if (nowdis < prevdis)
                        my[1] = peek[0];
                }
            }
            my[0] += stack.size();
            stack.add(new int[]{i, arr[i]});
        }

        for (int i = 1; i <= n; i++) {
            int[] list = answer.get(i);
            if (list[0] == 0){
                System.out.println(0);
            }else{
                System.out.println(list[0] + " " + list[1]);
            }
        }


    }

}
