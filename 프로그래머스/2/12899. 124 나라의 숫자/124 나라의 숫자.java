class Solution {
    public String solution(int n) {
        String[] num = new String[]{"4", "1", "2"};
        StringBuilder answer = new StringBuilder();
        
        while(n>0) {
            int mod = n%3;
            
            if(mod==0) {
                n--;
            }
            
            answer.append(num[mod]);
            n/=3;
        }
        
        
        return answer.reverse().toString();
    }
}