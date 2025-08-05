import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, maxDist=0, startNode=0;
    static List<List<Node>> tree;
    static  boolean[] visited;
    static class Node {
        int to;
        int dist;
        public Node(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        tree = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            tree.add(new ArrayList<>());
        }

        for(int i=1; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            tree.get(from).add(new Node(to, dist));
            tree.get(to).add(new Node(from, dist));
        }

        visited = new boolean[N+1];
        dfs(1, 0);

        visited = new boolean[N+1];
        maxDist=0;
        dfs(startNode, 0);

        System.out.println(maxDist);
    }

    static void dfs(int n, int dist) {
        if(dist>maxDist) {
            maxDist=dist;
            startNode=n;
        }
        visited[n]=true;
        for(Node node:tree.get(n)) {
            if(!visited[node.to]){
                dfs(node.to, dist+node.dist);
            }
        }
    }

}
