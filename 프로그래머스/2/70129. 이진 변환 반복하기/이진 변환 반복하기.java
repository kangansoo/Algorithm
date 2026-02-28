
class Solution {
    
    static StringBuilder sb;
    
    public int[] solution(String s) {
        int[] answer = new int[2];
        int zeroCnt=0;
        int convertCnt=0;
        
        while(!s.equals("1")) {
            String tmp = s.replace("0", "");

            zeroCnt+=s.length()-tmp.length();
            s=convertBinary(tmp.length());
            
            convertCnt++;
        }
        
        answer[0] = convertCnt;
        answer[1] = zeroCnt;
        
        return answer;
    }
    
    static String convertBinary(int num) {
        sb = new StringBuilder();
        
        while(num>0) {
            sb.append(num%2);
            num/=2;
        }
        
        return sb.toString();
    }
}