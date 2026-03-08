import java.util.*;

class Solution {
    static char[] expressions = {'*', '+', '-'};
    static char[] orders = new char[3];
    static boolean[] selected = new boolean[3];
    static long answer=0;
    static List<Long> nums = new ArrayList<>();
    static List<Character> ops = new ArrayList<>();
    
    public long solution(String expression) {
        int idx=0;
        for(int i=0; i<expression.length(); i++) {
            char ch = expression.charAt(i);
            if(ch=='+' || ch=='-' || ch=='*'){
                ops.add(ch);
                nums.add(Long.parseLong(expression.substring(idx, i)));
                idx=i+1;
            }
        }
        nums.add(Long.parseLong(expression.substring(idx)));
        
        perm(0);
        
        return answer;
    }
    
    static void perm(int depth) {
        if(depth==3) {
            run();
            return;
        }
        
        for(int i=0; i<3; i++) {
            if(selected[i]) continue;
            selected[i]=true;
            orders[depth]=expressions[i];
            perm(depth+1);
            selected[i]=false;
        }
    }
    
    static void run() {
        List<Long> copiedNums = new ArrayList<>(nums);
        List<Character> copiedOps = new ArrayList<>(ops);
        
        for(char currOp : orders) {
            Stack<Long> numStack = new Stack<>();
            Stack<Character> opStack = new Stack<>();
            
            numStack.push(copiedNums.get(0));
            for(int i=0; i<copiedOps.size(); i++) {
                long nextNum = copiedNums.get(i+1);
                char op = copiedOps.get(i);
                
                if(op==currOp) {
                    long prevNum = numStack.pop();
                    numStack.push(calc(prevNum, nextNum, op));
                } else {
                    numStack.push(nextNum);
                    opStack.push(op);
                }
            }
            
            copiedNums = new ArrayList<>(numStack);
            copiedOps = new ArrayList<>(opStack);
        }
        answer = Math.max(answer, Math.abs(copiedNums.get(0)));
    }
    
    static long calc(long a, long b, char o) {
        long res = 0;
        switch(o) {
            case '*':
                res = a*b;
                break;
            case '+':
                res = a+b;
                break;
            case '-':
                res = a-b;
                break;
        }
        return res;
    }
}