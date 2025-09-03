import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i=0; i<s.length(); i++) {
            if(check(s)) answer++;
            char tmp = s.charAt(0);
            s = s.substring(1, s.length())+tmp;
        }
        
        return answer;
    }
    
    static boolean check(String str) {
        Stack<Character> stack = new Stack();
        for(int i=0; i<str.length(); i++) {
            char tmp = str.charAt(i);
            if(tmp=='(' || tmp=='[' || tmp=='{') {
                stack.push(tmp);
            } else {
                if(stack.isEmpty()) return false;
                char t=stack.pop();
                if(tmp==')' && t!='(') return false;
                if(tmp==']' && t!='[') return false;
                if(tmp=='}' && t!='{') return false;
            }
            
        }
        return stack.isEmpty();
    }
}