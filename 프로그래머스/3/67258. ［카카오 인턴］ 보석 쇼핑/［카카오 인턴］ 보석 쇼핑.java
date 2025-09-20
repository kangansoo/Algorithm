import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> target = new HashSet<>();
        for(String gem:gems) {
            target.add(gem);
        }
        int size = target.size();
        int len = gems.length;
        
        Map<String, Integer> map = new HashMap<>();
        int left=0, right=0;
        int start=0, minLen=len+1;
        
        while(true) {
            if(map.size()==size) {
                if(right-left<minLen) {
                    minLen = right-left;
                    start = left;
                }
                map.put(gems[left], map.get(gems[left])-1);
                if(map.get(gems[left])==0) {
                    map.remove(gems[left]);
                }
                left++;
            } else {
                if(right==len) break;
                map.put(gems[right], map.getOrDefault(gems[right], 0)+1);
                right++;
            }
        }
        
        return new int[]{start+1, start+minLen};
    }
}