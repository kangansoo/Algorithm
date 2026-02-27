class Solution {
    public String solution(String s) {
        String answer = "";
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        String[] arr = s.split(" ");
        
        for(String a:arr) {
            // System.out.print(isNegative(a));
            int tmp=0;
            if(isNegative(a)) {
                tmp = Integer.parseInt(a.substring(1)) *(-1);
            } else {
                tmp = Integer.parseInt(a);
            }
            
            if(tmp<min) min=tmp;
            if(tmp>max) max=tmp;
        }
        
        answer+=min+" "+max;
        
        return answer;
    }
    
    public boolean isNegative(String str) {
        if(str.charAt(0)!='-') return false;
        return true;
    }
}