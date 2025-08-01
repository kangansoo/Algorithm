import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K, S, X, Y;
    static int[][] deltas={{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static Virus[][] map;
    static boolean[][] visited;
    static Queue<Virus> q;
    static class Virus implements Comparable<Virus>{
        int x;
        int y;
        int v;

        public Virus(int x, int y, int v) {
            this.x = x;
            this.y = y;
            this.v = v;
        }

        @Override
        public int compareTo(Virus o) {
            return this.v - o.v;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new Virus[N][N];
        visited = new boolean[N][N];
        q = new LinkedList<>();


        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num!=0) {
                    q.add(new Virus(i, j, num));
                    map[i][j] = new Virus(i, j, num);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        for(int s=0; s<S; s++){
            bfs();
        }

        if(map[X-1][Y-1]==null) {
            System.out.println(0);
        } else {
            System.out.println(map[X-1][Y-1].v);
        }
    }

    static void bfs() {
        PriorityQueue<Virus> pq = new PriorityQueue<>();
        while(!q.isEmpty()){
            pq.add(q.poll());
        }

        while(!pq.isEmpty()) {
            Virus curr = pq.poll();
            int x = curr.x;
            int y = curr.y;
            int v = curr.v;

            for(int d=0; d<4; d++){
                int dx = x+deltas[d][0];
                int dy = y+deltas[d][1];
                if(dx>=0 && dx<N && dy>=0 && dy<N && map[dx][dy]==null) {
                    q.add(new Virus(dx, dy, v));
                    map[dx][dy] = new Virus(dx, dy, v);
                }
            }
        }
    }
}
