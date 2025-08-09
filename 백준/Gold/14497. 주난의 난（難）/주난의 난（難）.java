import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int N, M, x1, y1, x2, y2;
    static char[][] map;
    static int[][] distance, deltas={{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    static class Node implements Comparable<Node> {
        int x, y, dist;
        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
        @Override
        public int compareTo(Node o) {
            return this.dist-o.dist;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        x1 = Integer.parseInt(st.nextToken())-1;
        y1 = Integer.parseInt(st.nextToken())-1;
        x2 = Integer.parseInt(st.nextToken())-1;
        y2 = Integer.parseInt(st.nextToken())-1;

        map = new char[N][M];
        distance = new int[N][M];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            map[i] = str.toCharArray();
            for(int j=0; j<M; j++) {
                distance[i][j] = INF;
            }
        }

        dijkstra();
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        distance[x1][y1]=0;
        pq.add(new Node(x1, y1, 0));

        while(!pq.isEmpty()) {
            Node curr = pq.poll();
            int x = curr.x;
            int y = curr.y;
            int dist = curr.dist;

            if(x==x2 && y==y2) {
                System.out.println(dist);
                return;
            }

            if(distance[x][y]<dist) continue;

            for(int d=0; d<4; d++) {
                int nx=x+deltas[d][0];
                int ny=y+deltas[d][1];

                if(nx>=0 && nx<N && ny>=0 && ny<M) {
                    int cost = map[nx][ny]=='0'?0:1;
                    int newDist = dist+cost;

                    if(newDist<distance[nx][ny]) {
                        distance[nx][ny]=newDist;
                        pq.add(new Node(nx, ny, newDist));
                    }
                }
            }
        }
    }
}
