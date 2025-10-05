import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dict = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        
        for(int i=0; i<26; i++) {
            dict.put(String.valueOf((char)('A'+i)), i+1);
        }
        
        for(int i=0; i<msg.length();) {
            String w = ""+msg.charAt(i);
            int j=i+1;
            
            while(j<=msg.length() && dict.containsKey(msg.substring(i, j))) {
                w = msg.substring(i, j);
                j++;
            }
            
            answer.add(dict.get(w));
            
            if(j<=msg.length()) {
                String c = msg.substring(i, j);
                dict.put(c, dict.size()+1);
            }
            
            i+=w.length();
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}