import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static int V, E, X, Y;
    static Node[] tree;
    static List<Integer> tmp1, tmp2;
    static public class Node {
        int val;
        int parent;
        List<Integer> children;

        public Node(int parent, int val){
            this.val=val;
            this.parent=parent;
            this.children = new ArrayList<>();
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());

            tree = new Node[V+1];
            for(int i=1; i<=V; i++){
                tree[i]=new Node(0, i);
            }
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<V-1; i++){
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                tree[b].parent=a;
                tree[a].children.add(b);
            }

            tmp1 = new ArrayList<>();
            tmp2 = new ArrayList<>();

            find(X, tmp1);
            find(Y, tmp2);

            int answer=0;

            int size = Math.min(tmp1.size(), tmp2.size());

            for(int i=0; i<size; i++){
                if(tmp1.get(i).equals(tmp2.get(i))){
                    answer=tmp1.get(i);
                }
            }

            System.out.println("#"+t+" "+answer+" "+dfs(answer));
        }
    }

    static void find(int idx, List<Integer> list){
        int parent = tree[idx].parent;
        if(parent!=0){
            find(parent, list);
        }
        list.add(idx);
    }

    static int dfs(int idx){
        int res = 1;
        for(int child:tree[idx].children){
            res+=dfs(child);
        }
        return res;
    }
}
