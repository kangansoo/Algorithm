

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static boolean isSolved=false;
    static int[] jiwoo, win;
    static int[][] graph;
    static boolean[] visited;
    static Queue<Integer> nj, nk, nm, k, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        graph = new int[N][N];
        visited = new boolean[N];
        jiwoo = new int[N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        k = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<20; i++) {
            k.add(Integer.parseInt(st.nextToken())-1);
        }

        m = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<20; i++) {
            m.add(Integer.parseInt(st.nextToken())-1);
        }

        dfs(0);

        if(isSolved) System.out.println(1);
        else System.out.println(0);
    }

    static void dfs(int depth) {
        if(isSolved) return;
        if(depth==N) {
            nj = new LinkedList<>();
            nk = new LinkedList<>(k);
            nm = new LinkedList<>(m);
            win = new int[3];
            for(int i=0; i<N; i++) {
                nj.add(jiwoo[i]);
            }
            game(0, 1);
        }
        for(int i=0; i<N; i++) {
            if(!visited[i]) {
                visited[i]=true;
                jiwoo[depth]=i;
                dfs(depth+1);
                visited[i]=false;
            }
        }
    }

    static void game(int a, int b) {
        if(win[0]>=K) {
            isSolved=true;
            return;
        }
        if(nk.isEmpty() || nm.isEmpty() || nj.isEmpty() || win[1]>=K || win[2]>=K) return;

        int next = 0;
        for(int i=0; i<3; i++) {
            if(i!=a && i!=b) {
                next=i;
                break;
            }
        }

        int p1=0;
        switch(a) {
            case 0:
                p1=nj.poll();
                break;
            case 1:
                p1=nk.poll();
                break;
            case 2:
                p1=nm.poll();
                break;
        }

        int p2=0;
        switch(b) {
            case 0:
                p2=nj.poll();
                break;
            case 1:
                p2=nk.poll();
                break;
            case 2:
                p2=nm.poll();
                break;
        }

        int result = graph[p1][p2];
        if(result==2) {
            win[a]++;
            game(a, next);
        } else if(result==0) {
            win[b]++;
            game(next, b);
        } else if(result==1) {
            if(a>b) {
                win[a]++;
                game(a, next);
            } else {
                win[b]++;
                game(next, b);
            }
        }
    }
}
