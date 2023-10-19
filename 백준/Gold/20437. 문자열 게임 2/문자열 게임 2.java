import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
//        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            sc.nextLine();
            String str = sc.nextLine();
            int k = sc.nextInt();
            if (k == 1){
                System.out.println("1 1");
                continue;
            }

            Map<Character, List<Integer>> map = new HashMap<>();
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int s = 0; s < str.length(); s++) {
                List<Integer> list = map.getOrDefault(str.charAt(s), new ArrayList<>());
                list.add(s);
                map.put(str.charAt(s), list);
            }
            for(List<Integer> l : map.values()){
                if (l.size() >= k) {
                    for (int j = 0; j < l.size() - k + 1; j++) {
                        int right = l.get(j + k - 1);
                        int left = l.get(j);
                        min = Math.min(min, right - left + 1);
                        max = Math.max(max, right - left + 1);
                    }
                }
            }

            if (min != Integer.MAX_VALUE)
                System.out.println(min + " " + max);
            else
                System.out.println(-1);
        }
    }
}