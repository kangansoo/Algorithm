import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;
        
        for(int q:queue1) {
            sum1+=q;
            q1.add(q);
        }
        
        for(int q:queue2) {
            sum2+=q;
            q2.add(q);
        }
        
        int answer = 0;
        
        while(answer<=queue1.length*4){
            if(sum1==sum2) return answer;
            
            if(sum1 < sum2) {
                int curr = q2.poll();
                sum2-=curr;
                sum1+=curr;
                q1.add(curr);
            } else if(sum1 > sum2) {
                int curr = q1.poll();
                sum1-=curr;
                sum2+=curr;
                q2.add(curr);
            } 
                answer++;
        }
        
        return -1;
    }
}