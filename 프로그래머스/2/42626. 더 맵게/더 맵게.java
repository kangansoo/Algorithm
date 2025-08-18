import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<scoville.length; i++) {
            pq.add(scoville[i]);
        }
        
        int answer = 0;
        
        while(pq.size()>1 && pq.peek()<K) {
            int curr = pq.poll();
            int next = pq.poll();
            int newScoville = curr+next*2;
            
            pq.add(newScoville);
            answer++;
            
        }
        
        return pq.peek()<K?-1:answer;
    }
}