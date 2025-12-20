

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[] parents, money;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        parents = new int[N+1];
        money = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            parents[i]=i;
            money[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        int cost=0;
        boolean[] check = new boolean[N+1];
        for(int i=1; i<=N; i++) {
            int a = find(i);

            if(!check[a]) {
                check[a]=true;
                cost+=money[a];
            }
            check[i]=true;
        }

        if(cost>K) System.out.println("Oh no");
        else System.out.println(cost);
    }

    static int find(int a) {
        if(a==parents[a]) return a;
        return parents[a]=find(parents[a]);
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if(money[pa]>money[pb]) parents[pa]=pb;
        else parents[pb]=pa;
    }
}
