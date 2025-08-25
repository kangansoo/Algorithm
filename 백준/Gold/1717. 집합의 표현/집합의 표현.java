import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] parent;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        for(int i=0; i<=N; i++) {
            parent[i]=i;
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            switch(c) {
                case 0:
                    union(a, b);
                    break;
                case 1:
                    if(find(a)==find(b)) sb.append("YES").append("\n");
                    else sb.append("NO").append("\n");
            }
        }

        System.out.println(sb);
    }

    static int find(int x) {
        if(parent[x]==x) return x;
        return parent[x]=find(parent[x]);
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if(pa!=pb) parent[pb]=pa;
    }
}
