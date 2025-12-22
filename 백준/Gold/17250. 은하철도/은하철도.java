

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parent, planet;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        planet = new int[n+1];
        for(int i=1; i<=n; i++) {
            parent[i] = i;
            planet[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
            sb.append(planet[find(a)]).append("\n");
        }
        System.out.println(sb);
    }

    static int find(int x) {
        if(parent[x]==x) return x;
        return parent[x]=find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a!=b) {
            parent[b]=a;
            planet[a]+=planet[b];
        }
    }
}
