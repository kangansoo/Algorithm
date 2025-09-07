import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<want.length; i++) {
            map.put(want[i], number[i]);
        }
        Map<String, Integer> copy;
        int answer = 0;
        
        for(int i=0; i<=discount.length-10; i++) {
            copy = new HashMap<>();
            copy.putAll(map);
            
            for(int j=i; j<i+10; j++) {
                String str = discount[j];
                if(copy.containsKey(str)) {
                    if(copy.get(str)-1==0) {
                        copy.remove(str);
                    } else {
                        copy.put(str, copy.get(str)-1);
                    }
                }
            }
            
            if(copy.size()==0) answer++;
        }
        
        return answer;
    }
}