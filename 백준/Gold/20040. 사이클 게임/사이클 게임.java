

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N];

        for(int i=0; i<N; i++) {
            parent[i]=i;
        }

        int answer=0;

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(find(a)==find(b)) {
                System.out.println(i+1);
                return;
            }
            union(a, b);
        }

        System.out.println(0);
    }

    static int find(int x){
        if(parent[x]==x) return x;
        return parent[x]=find(parent[x]);
    }

    static void union(int x,int y){
        int px=find(x);
        int py=find(y);
        if(px!=py) parent[py]=px;
    }
}
