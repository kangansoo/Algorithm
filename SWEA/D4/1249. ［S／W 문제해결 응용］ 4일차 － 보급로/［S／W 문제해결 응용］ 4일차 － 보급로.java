import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution {
    static int N;
    static final int INF = Integer.MAX_VALUE;
    static int[][] map, dist, deltas={{0, 1}, {-1, 0}, {0, -1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            sb.append("#").append(t).append(" ");
            N = Integer.parseInt(br.readLine());

            map = new int[N][N];
            dist = new int[N][N];

            for(int i=0; i<N; i++){
                String str = br.readLine();
                for(int j=0; j<N; j++){
                    map[i][j]=str.charAt(j)-'0';
                    dist[i][j]=INF;
                }
            }

            dijkstra();

            sb.append(dist[N-1][N-1]).append("\n");
        }

        System.out.println(sb);

    }

    static void dijkstra(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->Integer.compare(a[2], b[2]));
        pq.add(new int[]{0, 0, 0});
        dist[0][0]=0;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int x = curr[0];
            int y = curr[1];
            int cost = curr[2];

            if(cost>dist[x][y]) continue;

            for(int d=0; d<4; d++){
                int nx = x+deltas[d][0];
                int ny = y+deltas[d][1];

                if(nx>=0 && nx<N && ny>=0 && ny<N){
                    int newDist = cost+map[nx][ny];
                    if(newDist<dist[nx][ny]){
                        dist[nx][ny]=newDist;
                        pq.add(new int[]{nx, ny, newDist});
                    }
                }
            }
        }
    }
}