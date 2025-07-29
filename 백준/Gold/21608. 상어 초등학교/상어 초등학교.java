import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map, deltas={{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static boolean[][] visited;
    static Map<Integer, int[]> friends;
    static class Seat implements Comparable<Seat> {
        int like;
        int empty;
        int x;
        int y;
        public Seat(int like, int empty, int x, int y) {
            this.like = like;
            this.empty = empty;
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Seat o) {
            if(this.like != o.like){
                return o.like-this.like;
            }
            if(this.empty != o.empty) {
                return o.empty-this.empty;
            }
            if(this.x != o.x) {
                return this.x-o.x;
            }
            return this.y-o.y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];
        visited = new boolean[N+1][N+1];
        friends = new HashMap<>();

        for(int i=0; i<N*N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int[] tmp = new int[4];
            for(int j=0; j<4; j++){
                tmp[j] = Integer.parseInt(st.nextToken());
            }
            friends.put(a, tmp);

            calc(a);
        }

        int answer=0;
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                answer+= (int) Math.pow(10, satisfaction(i, j)-1);
            }
        }
        System.out.println(answer);
    }

    static void calc(int n) {
        PriorityQueue<Seat> pq = new PriorityQueue<>();
        int[] favorite = friends.get(n);
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(visited[i][j]) continue;
                int like=0;
                int empty=0;
                for(int d=0; d<4; d++){
                    int dx = i+deltas[d][0];
                    int dy = j+deltas[d][1];

                    if(dx>0 && dx<=N && dy>0 && dy<=N){
                        for(int f:favorite){
                            if(map[dx][dy]==f) like++;
                        }
                        if(map[dx][dy]==0) empty++;
                    }
                }
                pq.add(new Seat(like, empty, i, j));
            }
        }

        if(!pq.isEmpty()){
            Seat seat = pq.poll();
            map[seat.x][seat.y] = n;
            visited[seat.x][seat.y]=true;
        }
    }

    static int satisfaction(int x, int y){
        int[] favorite = friends.get(map[x][y]);
        int cnt=0;

        for(int d=0; d<4; d++){
            int dx = x+deltas[d][0];
            int dy = y+deltas[d][1];

            if(dx>0 && dx<=N && dy>0 && dy<=N){
                for(int f:favorite){
                    if(map[dx][dy]==f) cnt++;
                }
            }
        }
        return cnt;
    }
}
