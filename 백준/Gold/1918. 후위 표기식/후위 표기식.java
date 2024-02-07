import java.io.*;
import java.util.*;

public class Main {
    static int n, m, w;
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            String str = br.readLine();
            Stack<Character> st = new Stack<>();
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);

                if (Character.isAlphabetic(ch))
                    System.out.print(ch);
                else if (ch == '(')
                    st.push(ch);
                else if (ch == '+' || ch == '-') {
                    while (!st.isEmpty() && st.peek() != '('){
                        System.out.print(st.pop());
                    }
                    st.push(ch);
                }else if (ch == '*' || ch == '/') {
                    while (!st.isEmpty() && (st.peek() == '*' || st.peek() == '/')) {
                        System.out.print(st.pop());
                    }
                    st.push(ch);
                } else if (ch == ')') {
                    while (st.peek() != '('){
                        System.out.print(st.pop());
                    }
                    st.pop();
                }
            }

            while (!st.isEmpty()){
                System.out.print(st.pop());
            }

        }
    }

}
