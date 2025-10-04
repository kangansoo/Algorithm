import java.util.*;

class Solution {
    static final int VAL = 65536;
    public int solution(String str1, String str2) {
        Map<String, Integer> a = new HashMap<>();
        Map<String, Integer> b = new HashMap<>();
        
        for(int i=0; i<str1.length()-1; i++) {
            char t1 = str1.charAt(i);
            char t2 = str1.charAt(i+1);
            
            if(!isEng(t1) || !isEng(t2)) continue;
            String key = (""+t1+t2).toUpperCase();
            a.put(key, a.getOrDefault(key, 0)+1);
        }
        
        for(int i=0; i<str2.length()-1; i++) {
            char t1 = str2.charAt(i);
            char t2 = str2.charAt(i+1);
            
            if(!isEng(t1) || !isEng(t2)) continue;
            String key = (""+t1+t2).toUpperCase();
            b.put(key, b.getOrDefault(key, 0)+1);
        }
        
        int union=0;
        int intersection=0;
        Set<String> keys = new HashSet<>();
        keys.addAll(a.keySet());
        keys.addAll(b.keySet());
        
        for(String key:keys) {
            int cntA = a.getOrDefault(key, 0);
            int cntB = b.getOrDefault(key, 0);
            
            union += Math.max(cntA, cntB);
            intersection += Math.min(cntA, cntB);
        }
        
        if(union==0) return VAL;
        return (int)((double)intersection/union*VAL);
    }
    
    static boolean isEng(char cha) {
        if((cha>='a' && cha<='z') || (cha>='A' && cha<='Z')) return true;
        return false;
    }
}