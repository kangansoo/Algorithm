import java.util.*;

class Solution {
    static int len;
    static boolean[] visited;
    static List<String> list;
    public String[] solution(String[][] tickets) {
        len = tickets.length;
        list = new ArrayList<>();
        visited = new boolean[len];
        
        dfs(0, tickets, "ICN", "ICN");
        
        Collections.sort(list);
        
        return list.get(0).split(" ");
    }
    
    static void dfs(int depth, String[][] tickets, String start, String path) {
        if(depth==len) {
            list.add(path);
            return;
        }
        for(int i=0; i<len; i++) {
            if(!visited[i] && start.equals(tickets[i][0])) {
                visited[i]=true;
                dfs(depth+1, tickets, tickets[i][1], path+" "+tickets[i][1]);
                visited[i]=false;
            }
        }
    }
}