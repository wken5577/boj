import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Main {
    static boolean flag = false;
    static int countAt = 0, countBt = 0;
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        DFS(s, t);
        if (flag)
            System.out.println(1);
        else
            System.out.println(0);
    }

    private static void DFS(String s, String t) {
        if (s.equals(t)){
            flag = true;
            return;
        }
        if (flag || s.length() >= t.length())
            return;
        if (t.charAt(t.length() - 1) == 'A'){
            DFS(s, t.substring(0, t.length() - 1));
        }
        if (t.charAt(0) == 'B'){
            StringBuilder sb = new StringBuilder(t.substring(1, t.length()));
            DFS(s, sb.reverse().toString());
        }
    }


}