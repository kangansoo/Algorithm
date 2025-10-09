import java.util.*;

class Solution {
    public String solution(String p) {
        if(isCorrect(p)) return p;
        return dfs(p);
    }
    
    static boolean isCorrect(String u) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<u.length(); i++) {
            char c = u.charAt(i);
            if(c=='(') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    
    static String dfs(String p) {
        if(p.length()==0) return p;
        
        String u="";
        String v="";
        int cnt1=0;
        int cnt2=0;
        
        for(int i=0; i<p.length(); i++) {
            char c = p.charAt(i);
            if(c=='(') cnt1++;
            else cnt2++;
            
            if(cnt1>0 && cnt1==cnt2) {
                u = p.substring(0, i+1);
                if(i<p.length()-1) v=p.substring(i+1, p.length());
                break;
            }
        }
        
        if(isCorrect(u)) {
            return u+dfs(v);
        } else {
            String tmp = "("+dfs(v)+")";
            u = u.substring(1, u.length()-1);
            u = u.replace("(", ":");
            u = u.replace(")", "(");
            u = u.replace(":", ")");
            tmp = tmp+u;
            return tmp;
        }
        
    }
}