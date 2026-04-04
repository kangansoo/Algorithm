

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int W, H, INF=Integer.MAX_VALUE, answer=Integer.MAX_VALUE;
    static char[][] map;
    static int[][] deltas={{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int[][][] dist;
    static int[] start, end;

    static public class Node implements Comparable<Node> {
        int x;
        int y;
        int d;
        int m;
        public Node(int x, int y, int d, int m) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.m = m;
        }

        @Override
        public int compareTo(Node o) {
            return this.m-o.m;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new char[H][W];
        dist = new int[H][W][4];

        start = new int[2];
        end = new int[2];

        boolean isStart=true;
        for(int i=0; i<H; i++) {
            String str = br.readLine();
            for(int j=0; j<W; j++) {
                char ch = str.charAt(j);
                map[i][j]=ch;
                if(ch=='C') {
                    if(isStart) {
                        start[0]=i;
                        start[1]=j;
                        isStart=false;
                    } else {
                        end[0]=i;
                        end[1]=j;
                    }
                }
            }
        }

        for(int i=0; i<H; i++) {
            for(int j=0; j<W; j++) {
                Arrays.fill(dist[i][j], INF);
            }
        }

        dijkstra();

        System.out.println(answer);
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for(int d=0; d<4; d++) {
            pq.add(new Node(start[0], start[1], d, 0));
        }

        while(!pq.isEmpty()) {
            Node curr= pq.poll();

            if(curr.x==end[0] && curr.y==end[1]) {
                answer=Math.min(answer, curr.m);
            }

            if(curr.m>dist[curr.x][curr.y][curr.d]) continue;

            for(int d=0; d<4; d++) {
                int nx = curr.x+deltas[d][0];
                int ny = curr.y+deltas[d][1];

                if(nx<0 || nx>=H || ny<0 || ny>=W || map[nx][ny]=='*') continue;
                int newMirror = (curr.d==d)?curr.m:curr.m+1;
                if(newMirror<dist[nx][ny][d]) {
                    dist[nx][ny][d]=newMirror;
                    pq.add(new Node(nx, ny, d, newMirror));
                }
            }
        }
    }
}
