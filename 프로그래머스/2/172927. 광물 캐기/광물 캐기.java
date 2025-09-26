class Solution {
    static int answer = Integer.MAX_VALUE;
    static int[][] graph = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
    public int solution(int[] picks, String[] minerals) {
        dfs(0, picks, minerals, 0);
        return answer;
    }
    
    static void dfs(int depth, int[] picks, String[] minerals, int cost) {
        if(depth>=minerals.length || (picks[0]==0 && picks[1]==0 && picks[2]==0)) {
            answer = Math.min(cost, answer);
            return;
        }
        
        for(int i=0; i<3; i++) {
            if(picks[i]<1) continue;
            picks[i]--;
            
            int newCost=0;
            for(int j=depth; j<Math.min(depth+5, minerals.length); j++) {
                int type = getNumber(minerals[j]);
                newCost+=graph[i][type];
            }
            
            dfs(depth+5, picks, minerals, cost+newCost);
            picks[i]++;
        }
    }
    
    static int getNumber(String mineral) {
        if(mineral.equals("diamond")) return 0;
        if(mineral.equals("iron")) return 1;
        return 2;
    }
}