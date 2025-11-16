

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, answer=0;
    static List<List<Integer>> graph;
    static boolean[] visited;
    static boolean isSolved;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for(int i=0; i<N; i++) {
            graph.add(new ArrayList<>());
        }

        isSolved = false;
        visited = new boolean[N];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int i=0; i<N; i++) {
            if(isSolved) break;
            visited[i]=true;
            dfs(i, 1);
            visited[i]=false;
        }

        System.out.println(answer);
    }

    static void dfs(int n, int depth) {
        if(isSolved) return;
        if(depth==5) {
            isSolved=true;
            answer=1;
        }

        for(int next : graph.get(n)) {
            if(visited[next]) continue;
            visited[next]=true;
            dfs(next, depth+1);
            visited[next]=false;
        }
    }
}
