import java.util.*;

class Solution {
    static class Node {
        String str;
        int cnt;
        public Node(String str, int cnt) {
            this.str=str;
            this.cnt=cnt;
        }
    }
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        int len = words.length;
        boolean flag=false;
        for(int i=0; i<len; i++) {
            if(target.equals(words[i])) flag=true;
        }
        
        if(!flag) return 0;
        
        boolean[] visited = new boolean[len];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(begin, 0));
        
        while(!q.isEmpty()) {
            Node curr = q.poll();
            if(curr.str.equals(target)) {
                answer=curr.cnt;
            }
            
            for(int i=0; i<len; i++) {
                if(!visited[i]) {
                    if(diff(curr.str, words[i])==1) {
                        visited[i]=true;
                        q.add(new Node(words[i], curr.cnt+1));
                    }
                }
            }
            
        }
        
        
        return answer;
    }
    
    static int diff(String curr, String next) {
        int cnt=0;
        
        char[] tmp1 = curr.toCharArray();
        char[] tmp2 = next.toCharArray();
        
        for(int i=0; i<tmp1.length; i++) {
            if(tmp1[i]!=tmp2[i]) cnt++;
        }
        
        return cnt;
    }
}