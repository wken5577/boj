import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.valueOf(st.nextToken());
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.valueOf(st.nextToken());
            int y = Integer.valueOf(st.nextToken());

            if (y == 0){
                answer += stack.size();
                stack.clear();
                continue;
            }
            if (!stack.isEmpty()){
                if (stack.peek() <= y)
                    stack.add(y);
                else {
                    while (!stack.isEmpty() && stack.peek() > y){
                        stack.pop();
                        answer++;
                    }
                    if (stack.isEmpty() || stack.peek() != y)
                        stack.add(y);
                }
            } else
                stack.add(y);
        }
        answer += stack.size();
        System.out.println(answer);


    }



}
