import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<progresses.length; i++) {
            q.add((int)Math.ceil((100-progresses[i])/(double)speeds[i]));
        }
        
        while(!q.isEmpty()) {
            int tmp=1;
            int curr = q.poll();
            while(!q.isEmpty() && q.peek()<=curr) {
                q.poll();
                tmp++;
            }
            answer.add(tmp);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}