import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList();
        String[] split = today.split("\\.");
        
        int year = Integer.valueOf(split[0]);
        int month = Integer.valueOf(split[1]);
        int day = Integer.valueOf(split[2]);
        int todayInt = day + (month * 28) + (year * 12 * 28);
        
        Map<String, Integer> map = new HashMap();
        for(int i = 0; i < terms.length; i++){
            split = terms[i].split(" ");
            map.put(split[0], Integer.valueOf(split[1]));
        }
        
        for(int i = 0; i < privacies.length; i++){
            split = privacies[i].split(" ");
            String date = split[0];
            String type = split[1];
            
            split = date.split("\\.");
            year = Integer.valueOf(split[0]);
            month = Integer.valueOf(split[1]);
            day = Integer.valueOf(split[2]);
            int dur = map.get(type);
            int fin = day + (month * 28) + (year * 12 * 28) + (dur * 28);
            
            
            if (todayInt >= fin)
                list.add(i + 1);
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}