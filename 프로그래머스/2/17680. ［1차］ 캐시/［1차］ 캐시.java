import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize==0) return cities.length*5;
        int answer = 0;
        LinkedList<String> cache = new LinkedList<>();
        
        for(String c:cities) {
            String city = c.toLowerCase();
            
            if(cache.remove(city)) {
                answer++;
                cache.addLast(city);
            } else {
                answer+=5;
                if(cache.size()==cacheSize) {
                    cache.removeFirst();
                }
                cache.addLast(city);
            }
        }
        
        return answer;
    }
}