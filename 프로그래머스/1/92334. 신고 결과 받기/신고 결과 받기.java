import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, List<String>> map = new HashMap<>();
        
        for(String id:id_list) {
            map.put(id, new ArrayList<>());
        }
        
        for(String r:report) {
            String[] str = r.split(" ");
            String reporter = str[0];
            String reported = str[1];
            
            if(!map.get(reported).contains(reporter)) {
                map.get(reported).add(reporter);
            }
        }
        
        Map<String, Integer> idxMap = new HashMap<>();
        for(int i=0; i<id_list.length; i++) {
            idxMap.put(id_list[i], i);
        }
        
        int[] answer = new int[id_list.length];
        
        for(List<String> names:map.values()) {
            if(names.size()>=k) {
                for(String name:names) {
                    answer[idxMap.get(name)]++;
                }
            }
        }
        
        return answer;
    }
}