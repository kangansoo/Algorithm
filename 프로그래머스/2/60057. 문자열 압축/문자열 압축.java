class Solution {
    public int solution(String s) {
        int len = s.length();
        int answer = len;
        
        for(int i=1; i<=len/2; i++) {
            StringBuilder sb = new StringBuilder();
            String curr=s.substring(0, i);
            int cnt=1;
            for(int j=i; j<len; j+=i) {
                String next = s.substring(j, Math.min(j+i, len));
                
                if(next.equals(curr)) {
                    cnt++;
                } else {
                    if(cnt>1) sb.append(cnt);
                    sb.append(curr);
                    curr=next;
                    cnt=1;
                }
            }
            
            if(cnt>1) sb.append(cnt);
            sb.append(curr);
            
            answer = Math.min(answer, sb.length());
        }
        
        return answer;
    }
}