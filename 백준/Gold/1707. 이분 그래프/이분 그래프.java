import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int V, E;
    static List<List<Integer>> adj;
    static int[] color;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int K = Integer.parseInt(br.readLine());

        for(int k=0; k<K; k++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            flag=true;

            adj = new ArrayList<>();
            for(int i=0; i<=V; i++) {
                adj.add(new ArrayList<>());
            }

            color = new int[V+1];

            for(int i=0; i<E; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                adj.get(from).add(to);
                adj.get(to).add(from);
            }

            for(int i=1; i<=V; i++) {
                if(color[i]==0) {
                    if(!bfs(i)) {
                        flag = false;
                        break;
                    }
                }
            }

            System.out.println(flag?"YES":"NO");
        }
    }

    static boolean bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        color[n]=1;

        while(!q.isEmpty()) {
            int curr = q.poll();
            for(int next:adj.get(curr)) {
                if(color[next]==0) {
                    color[next]=-color[curr];
                    q.add(next);
                } else {
                    if(color[next]==color[curr]) return false;
                }

            }
        }
        return true;
    }
}
