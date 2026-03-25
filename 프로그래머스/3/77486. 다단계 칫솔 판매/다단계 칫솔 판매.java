import java.util.*;

class Solution {
    static Map<String, String> parent = new HashMap<>();
    static Map<String, Integer> profit = new HashMap<>();
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int n = enroll.length;
        int[] answer = new int[n];
        
        for(int i=0; i<n; i++) {
            parent.put(enroll[i], referral[i]);
        }
        
        for(int i=0; i<seller.length; i++) {
            share(seller[i], amount[i]*100);
        }
        
        for(int i=0; i<n; i++) {
            answer[i] = profit.getOrDefault(enroll[i], 0);
        }
        
        return answer;
    }
    
    static void share(String seller, int sales) {
        int parentProfit = sales/10;
        
        profit.put(seller, profit.getOrDefault(seller, 0)+sales-parentProfit);
        
        if(parentProfit>0 && parent.containsKey(seller)) {
            share(parent.get(seller), parentProfit);
        }
    }
}