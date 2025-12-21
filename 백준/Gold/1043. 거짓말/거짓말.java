

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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
            parent[i]=i;
        }

        st = new StringTokenizer(br.readLine());
        int truthCnt = Integer.parseInt(st.nextToken());
        if(truthCnt==0) {
            System.out.println(m);
            return;
        }

        int[] truthPeople = new int[truthCnt];
        for(int i=0; i<truthCnt; i++) {
            truthPeople[i] = Integer.parseInt(st.nextToken());
        }

        List<int[]> parties = new ArrayList<>();
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            int[] party = new int[size];
            for(int j=0; j<size; j++) {
                party[j]=Integer.parseInt(st.nextToken());
            }
            parties.add(party);

            int tmp = party[0];
            for(int j=1; j<size; j++) {
                union(tmp, party[j]);
            }
        }

        for(int i=1; i<truthCnt; i++) {
            union(truthPeople[0], truthPeople[i]);
        }

        int result=0;
        for(int[] party:parties) {
            boolean canLie = true;
            for(int p:party) {
                if(find(p)==find(truthPeople[0])) {
                    canLie=false;
                    break;
                }
            }
            if(canLie) result++;
        }

        System.out.println(result);
    }

    static int find(int x) {
        if(x==parent[x]) return x;
        return parent[x]=find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a!=b) parent[b]=a;
    }
}
