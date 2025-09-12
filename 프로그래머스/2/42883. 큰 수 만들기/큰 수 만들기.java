import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        
        for(char c:number.toCharArray()) {
            while(!stack.isEmpty() && k>0 && stack.peek()<c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        
        while(k>0) {
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}