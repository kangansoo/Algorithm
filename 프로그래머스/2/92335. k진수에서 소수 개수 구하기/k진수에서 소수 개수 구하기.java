class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String num="";
        
        while(n!=0) {
            num = n%k+num;
            n/=k;
        }
        
        String[] arr = num.split("0");
        
        for(String a:arr) {
            if(a.equals("")) continue;
            long tmp = Long.parseLong(a);
            if(isPrime(tmp)) answer++;
        }
        
        return answer;
    }
    
    static boolean isPrime(long p) {
        if(p<2) return false;
        
        for(int i=2; i<=Math.sqrt(p); i++) {
            if(p%i==0) return false;
        }
        return true;
    }
}