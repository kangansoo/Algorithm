import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0)+plays[i]);
        }
        
        List<Integer> li = new ArrayList<>();
        for(int i=0; i<genres.length; i++) {
            li.add(i);
        }
        
        li.sort((a, b)->{
            if(!genres[a].equals(genres[b])) return map.get(genres[b])-map.get(genres[a]);
            else if (plays[a]!=plays[b])return plays[b]-plays[a];
            else return a-b;
        });
        
        List<Integer> result = new ArrayList<>();
        HashMap<String, Integer> cnt = new HashMap<>();
        
        for(int l:li) {
            cnt.put(genres[l], cnt.getOrDefault(genres[l], 0)+1);
            if(cnt.get(genres[l])<=2) {
                result.add(l);
            }
        }
        
        int len = result.size();
        int[] answer = new int[len];
        
        for(int i=0; i<len; i++) {
            answer[i]=result.get(i);
        }
        
        return answer;
    }
}