import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        
        for(int e:elements) {
            q.add(e);
        }
        
        for(int i=0; i<elements.length; i++) {
            int curr = q.poll();
            int sum=curr;
            set.add(curr);
            for(int j=0; j<elements.length-1; j++) {
                int tmp = q.poll();
                sum+=tmp;
                set.add(sum);
                q.add(tmp);
            }
            q.add(curr);
        }
        
        return set.size();
    }
}