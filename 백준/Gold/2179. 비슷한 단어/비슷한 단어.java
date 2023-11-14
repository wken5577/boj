import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static String[] strArr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        strArr = new String[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            strArr[i] = st.nextToken();
        }

        TreeMap<Integer, LinkedHashMap<String, LinkedHashSet<String>>> treeMap = new TreeMap<>();
        for (int len = 0; len <= 100; len++) {
            for (int i = 0; i < n; i++) {
                if (strArr[i].length() >= len + 1){
                    LinkedHashMap<String, LinkedHashSet<String>> hm = treeMap.getOrDefault(len + 1, new LinkedHashMap<>());
                    String key = strArr[i].substring(0, len + 1);
                    LinkedHashSet<String> list = hm.getOrDefault(key, new LinkedHashSet<>());
                    list.add(strArr[i]);
                    hm.put(key, list);
                    treeMap.put(len + 1, hm);
                }
            }
        }
        NavigableSet<Integer> integers = treeMap.descendingKeySet();
        for(int i : integers){
            LinkedHashMap<String, LinkedHashSet<String>> hm = treeMap.get(i);
            for (LinkedHashSet<String> list : hm.values()){
                if (list.size() >= 2){
                    Iterator<String> iterator = list.iterator();
                    System.out.println(iterator.next());
                    System.out.println(iterator.next());
                    return;
                }
            }
        }
        System.out.println(strArr[0]);
        System.out.println(strArr[1]);
    }


}
