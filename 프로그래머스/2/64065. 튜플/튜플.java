import java.util.*;

class Solution {
    public int[] solution(String s) {
        List<Integer> answer = new ArrayList<>();
        
        s = s.substring(2, s.length()-2).replace("},{", " ");
        String[] str = s.split(" ");
        
        Arrays.sort(str, Comparator.comparingInt(String::length));
        
        for(String st:str) {
            String[] tmp = st.split(",");
            
            for(int i=0; i<tmp.length; i++) {
                int num = Integer.parseInt(tmp[i]);
                
                if(!answer.contains(num)) {
                    answer.add(num);
                }
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}