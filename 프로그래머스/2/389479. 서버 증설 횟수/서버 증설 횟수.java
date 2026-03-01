class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] servers = new int[players.length+k];
        int runningServer = 0;
        
        for(int i=0; i<players.length; i++) {
            runningServer -= servers[i];
            
            int requiredServer = players[i]/m;
            
            if(requiredServer>runningServer) {
                int tmp = requiredServer-runningServer;
                answer+=tmp;
                runningServer+=tmp;
                servers[i+k]=tmp;
            }
        }
        
        
        return answer;
    }
}