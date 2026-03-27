import java.util.*;

class Solution {
    static int answer = 0;
    static List<List<Integer>> adj = new ArrayList<>();
    public int solution(int[] info, int[][] edges) {
        
        for(int i=0; i<info.length; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge:edges) {
            adj.get(edge[0]).add(edge[1]);
        }
        
        List<Integer> next = new ArrayList<>();
        
        next.add(0);
        
        dfs(0, 0, 0, next, info);
        
        
        return answer;
    }
    
    static void dfs(int curr, int lamb, int wolf, List<Integer> next, int[] info) {
        if(info[curr]==0) lamb++;
        else wolf++;
        
        if(wolf>=lamb) return;
        answer = Math.max(lamb, answer);
        
        List<Integer> nextNodes = new ArrayList<>(next);
        nextNodes.remove(Integer.valueOf(curr));
        
        for(int nextNode:adj.get(curr)) {
            nextNodes.add(nextNode);
        }
        
        for(int nextNode:nextNodes) {
            dfs(nextNode, lamb, wolf, nextNodes, info);
        }
        
    }
}