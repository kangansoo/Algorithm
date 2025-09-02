import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> bro1 = new HashMap<>();
        Map<Integer, Integer> bro2 = new HashMap<>();
        
        for(int t:topping) {
            bro1.put(t, bro1.getOrDefault(t, 0)+1);
        }
        
        for(int t:topping) {
            bro2.put(t, bro2.getOrDefault(t, 0)+1);
            
            if(bro1.get(t)-1==0) {
                bro1.remove(t);
            } else {
                bro1.put(t, bro1.get(t)-1);
            }
            
            if(bro1.size()==bro2.size()) answer++;
        }
        
        return answer;
    }
}