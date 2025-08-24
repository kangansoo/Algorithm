import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int len = citations.length;
        int answer = 0;
        
        Arrays.sort(citations);
        
        for(int i=0; i<len; i++) {
            int h = len-i;
            if(citations[i]>=h) {
                answer=h;
                break;
            }
        }
        
        return answer;
    }
}