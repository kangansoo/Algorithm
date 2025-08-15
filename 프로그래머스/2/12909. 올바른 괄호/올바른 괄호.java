class Solution {
    boolean solution(String s) {
        int cnt = 0;
        boolean res=true;
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c=='(') cnt++;
            if(c==')') cnt--;
            if(cnt<0) break;
        }
        
        
        return cnt==0;
    }
}