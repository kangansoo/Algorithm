

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        for(int i=1; i<=N; i++) {
            parent[i]=i;
        }

        for(int i=0; i<N-2; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        int a=find(1);
        int b=0;
        for(int i=2; i<=N; i++) {
            if(find(i)!=a) {
                b=find(i);
                break;
            }
        }

        System.out.println(a+" "+b);
    }

    static int find(int x) {
        if(x==parent[x]) return x;
        return parent[x]=find(parent[x]);
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if(pa!=pb) parent[pb]=pa;
    }
}
