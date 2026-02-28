
class Solution {
    
    static StringBuilder sb;
    
    public int[] solution(String s) {
        int[] answer = new int[2];
        int cnt=0;
        
        while(!s.equals("1")) {
            String[] curr = removeZero(s);
            
            answer[1] += Integer.parseInt(curr[1]);
            s=convertBinary(curr[0]);
            
            cnt++;
        }
        
        answer[0]=cnt;
        
        return answer;
    }
    
    static String[] removeZero(String s) {
        sb = new StringBuilder();
        int cnt=0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)!='0') sb.append(s.charAt(i));
            else cnt++;
        }
        return new String[]{sb.toString(), cnt+""};
    }
    
    static String convertBinary(String str) {
        sb = new StringBuilder();
        int num = str.length();
        
        while(num>0) {
            sb.append(num%2);
            num/=2;
        }
        
        return sb.toString();
    }
}