import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static int N;
    static final int INF=Integer.MAX_VALUE;
    static int[][] dist, map, deltas={{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        map = new int[N][N];
        dist = new int[N][N];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = str.charAt(j)-'0';
                dist[i][j]=INF;
            }
        }
        dijkstra();

        System.out.println(dist[N-1][N-1]);
    }



    static void dijkstra(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> Integer.compare(a[2], b[2]));
        pq.add(new int[]{0, 0, 0});
        dist[0][0]=0;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int x = curr[0];
            int y = curr[1];
            int cost = curr[2];

            if (cost > dist[x][y]) continue;

            for(int d=0; d<4; d++){
                int nx = x+deltas[d][0];
                int ny = y+deltas[d][1];

                if(nx>=0 && nx<N && ny>=0 && ny<N){
                    int newCost = cost + (map[nx][ny] == 0 ? 1 : 0);
                    if (newCost < dist[nx][ny]) {
                        dist[nx][ny] = newCost;
                        pq.add(new int[]{nx, ny, newCost});
                    }
                }

            }

        }
    }
}