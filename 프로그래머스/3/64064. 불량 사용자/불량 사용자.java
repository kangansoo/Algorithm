import java.util.*;

class Solution {
    static int u, b, answer=0;
    static boolean[][] checked;
    static boolean[] visited;
    static Set<String> set = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        // int answer = 0;
        
        u = user_id.length;
        b = banned_id.length;
        
        checked = new boolean[b][u];
        visited = new boolean[u];
        
        for(int i=0; i<b; i++) {
            for(int j=0; j<u; j++) {
                
                boolean flag=true;
                String banned = banned_id[i];
                String user = user_id[j];
                
                if(banned.length() != user.length()) continue;
                
                for(int k=0; k<banned.length(); k++) {
                    if(banned.charAt(k)=='*') continue;
                    if(banned.charAt(k)!=user.charAt(k)) {
                        flag=false;
                        break;
                    }
                }
                
                if(flag) checked[i][j]=true;
            }
        }
        
        dfs(0);
        
        return set.size();
    }
    
    static void dfs(int depth) {
        if(depth==b) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<u; i++) {
                if(visited[i]) sb.append(i);
            }
            set.add(sb.toString());
            return;
        }
        
        for(int i=0; i<u; i++) {
            if(visited[i]) continue;
            if (checked[depth][i]) {
                visited[i]=true;
                dfs(depth+1);
                visited[i]=false;
            }
        }
    }
}