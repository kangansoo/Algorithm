import java.util.*;

class Solution {
    static Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        boolean[] visited = new boolean[numbers.length()];

        perm(visited, "", numbers);
        
        int answer=0;
        
        for(int num:set) {
            if(isPrime(num)) answer++;
        }
        
        return answer;
    }
    
    static void perm(boolean[] visited, String num, String number) {
        if(num.length()!=0) {
            set.add(Integer.parseInt(num));
        }
        
        for(int i=0; i<number.length(); i++) {
            if(!visited[i]) {
                visited[i]=true;
                perm(visited, num+number.charAt(i), number);
                visited[i]=false;    
            }
        }
        
    }
    
    static boolean isPrime(int num) {
        if(num<=1) return false;
        for(int i=2; i<=Math.sqrt(num); i++) {
            if(num%i==0) return false;
        }
        return true;
    }
}