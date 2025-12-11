

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, count;
    static int delete, root;
    static boolean[] visited;
    static List<List<Integer>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        graph = new ArrayList<>();
        for(int i=0; i<N; i++) {
            graph.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if(n==-1) {
                root = i;
            } else {
                graph.get(n).add(i);
            }
        }

        delete = Integer.parseInt(br.readLine());

        if(root==delete) System.out.println(0);
        else {
            dfs(root);
            System.out.println(count);
        }
    }

    static void dfs(int start) {
        boolean hasChild = false;
        visited[start]=true;
        for(int next:graph.get(start)) {
            if(next==delete) continue;

            hasChild = true;

            if(!visited[next]) {
                dfs(next);
            }
        }
        if(!hasChild) count++;
    }
}
