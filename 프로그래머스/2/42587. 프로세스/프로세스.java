import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> q = new LinkedList<>();
        int answer = 0;
        
        int len = priorities.length;
        boolean[] visited = new boolean[len];
        
        for(int i=0; i<len; i++) {
            q.add(i);
        }
        
        while(!q.isEmpty()) {
            int curr = q.poll();
            if(isMax(curr, priorities, visited)) {
                visited[curr]=true;
                answer++;
                if(curr==location) break;
            } else {
                q.add(curr);
            }
        }
        
        
        return answer;
    }
    
    static boolean isMax(int n, int[] arr, boolean[] visited) {
        for(int i=0; i<arr.length; i++) {
            if(arr[i]>arr[n] && !visited[i]) return false;
        }
        return true;
    }
}