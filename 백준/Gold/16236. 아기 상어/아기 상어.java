import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, sharkSize=2, time=0, eatCnt;
    static int[][] map, deltas={{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    static PriorityQueue<Fish> pq;
    static Fish shark;
    static class Fish implements Comparable<Fish> {
        int x, y, dist;
        public Fish(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
        @Override
        public int compareTo(Fish o) {
            if(this.dist!=o.dist) return this.dist-o.dist;
            if(this.x!=o.x) return this.x-o.x;
            return this.y-o.y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num==9) {
                    shark = new Fish(i, j, 0);
                    map[i][j]=0;
                    continue;
                }
                map[i][j] = num;
            }
        }

        while(true) {
            bfs();
            if(pq.isEmpty()) break;
            Fish fish = pq.poll();

            map[fish.x][fish.y]=0;
            shark.x=fish.x;
            shark.y=fish.y;
            time+=fish.dist;
            eatCnt++;

            if(eatCnt==sharkSize) {
                sharkSize++;
                eatCnt=0;
            }
        }

        System.out.println(time);

    }

    static void bfs() {
        pq = new PriorityQueue<>();
        Queue<Fish> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        q.add(shark);
        visited[shark.x][shark.y]=true;

        while(!q.isEmpty()) {
            Fish shark = q.poll();
            int nx = shark.x;
            int ny = shark.y;

            for(int d=0; d<4; d++) {
                int dx = nx+deltas[d][0];
                int dy = ny+deltas[d][1];

                if(dx>=0 && dx<N && dy>=0 && dy<N && !visited[dx][dy] && map[dx][dy]<=sharkSize) {
                    if(map[dx][dy]>0 && map[dx][dy]<sharkSize) {
                        pq.add(new Fish(dx, dy, shark.dist+1));
                    }
                    visited[dx][dy]=true;
                    q.add(new Fish(dx, dy, shark.dist+1));
                }
            }

        }
    }
}