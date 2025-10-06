import java.util.*;

class Solution {
    static Map<String, Integer> map;
    static boolean[] isSelected;
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        for(int c:course) {
            map = new HashMap<>();
            
            for(String order:orders) {
                char[] arr = order.toCharArray();
                Arrays.sort(arr);
                
                dfs(0, arr, c, new StringBuilder());
            }
            
            int max=0;
            for(int cnt:map.values()) {
                if(cnt>1) max = Math.max(max, cnt);
            }
            
            for(String key:map.keySet()) {
                if(map.get(key)==max && max>1) answer.add(key);
            }
        }
        
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
    
    static void dfs(int start, char[] order, int c, StringBuilder sb) {
        if(sb.length()==c) {
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }
        
        for(int i=start; i<order.length; i++) {
            sb.append(order[i]);
            dfs(i+1, order, c, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}