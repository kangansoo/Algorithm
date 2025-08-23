import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] str = new String[numbers.length];
        
        for(int i=0; i<numbers.length; i++) {
            str[i]=Integer.toString(numbers[i]);
        }
        
        Arrays.sort(str, (a, b)-> (b+a).compareTo(a+b));
        
        for(int i=0; i<str.length; i++) {
            if(i==0) {
                if(str[0].equals("0")) {
                    answer="0";
                    break;
                };
            }
            answer+=str[i];
        }
        
        return answer;
    }
}