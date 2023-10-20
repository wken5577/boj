import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long s1 = 0;
        long s2 = 0;
        for(int i = 0; i < queue1.length; i++){
            s1 += queue1[i];
            s2 += queue2[i];
        }
        if ((s1 + s2) % 2 != 0)
            return -1;
        Queue<Long> q1 = new LinkedList(Arrays.stream(queue1)
                                        .mapToLong(Long::valueOf).boxed().collect(Collectors.toList()));
        Queue<Long> q2 = new LinkedList(Arrays.stream(queue2).
                                        mapToLong(Long::valueOf).boxed().collect(Collectors.toList()));
        
        long tar = (s1 + s2) / 2;
        
        int cnt = 0;
        while (cnt < queue1.length * 3){
            if (s1 == tar)
                return answer;
            if (s1 > s2){
                s1 -= q1.peek().longValue();
                s2 += q1.peek().longValue();
                q2.add(q1.poll());
            }else{
                s2 -= q2.peek().longValue();
                s1 += q2.peek().longValue();
                q1.add(q2.poll());
            }
            answer++;
            cnt++;
        }
        
        return -1;
    }
}