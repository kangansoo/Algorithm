

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for(int i=1; i<=n; i++) {
            parent[i] = i;
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        st = new StringTokenizer(br.readLine());
        int[] classes = new int[n];
        for(int i=0; i<n; i++) {
            classes[i] = Integer.parseInt(st.nextToken());
        }

        int result=0;
        for(int i=1; i<n; i++) {
            if(find(classes[i-1])!=find(classes[i])) result+=1;
        }
        System.out.println(result);
    }

    static int find(int x) {
        if(parent[x]==x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a!=b) parent[b]=a;
    }
}
