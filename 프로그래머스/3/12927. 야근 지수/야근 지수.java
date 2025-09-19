import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int work:works) {
            pq.add(work);
        }

        while(n!=0) {
            int work = pq.poll();
            if(work==0) break;
            work--;
            pq.add(work);
            n--;
        }
        long answer = 0;
        
        while(!pq.isEmpty()) {
            int tmp = pq.poll();
            answer += (long)tmp*tmp;
        }
        return answer;
    }
}