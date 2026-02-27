class Solution {
    public String solution(String s) {
        String answer = "";
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        String[] arr = s.split(" ");
        
        for(String a:arr) {
            int tmp = Integer.parseInt(a);
            
            min = Math.min(tmp, min);
            max = Math.max(tmp, max);
        }
        
        answer+=min+" "+max;
        
        return answer;
    }
}