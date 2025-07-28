import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int r, c, k, R=3, C=3;
    static int[][] A = new int[101][101];
    static class Node implements Comparable<Node>{
        int key;
        int value;
        public Node(int x, int y){
            this.key=x;
            this.value=y;
        }

        @Override
        public int compareTo(Node o) {
            if(this.value>o.value){
                return 1;
            } else if(this.value==o.value){
                return this.key-o.key;
            } else {
                return -1;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());


        for(int i=1; i<=R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=C; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt=0;
        while(true){
            if(cnt>100) {
                System.out.println(-1);
                return;
            }
            if(A[r][c]==k){
                System.out.println(cnt);
                return;
            }

            if(R>=C){
                for(int i=1; i<=R; i++){
                    simRow(i);
                }
            } else {
                for(int i=1; i<=C; i++){
                    simCol(i);
                }
            }

            cnt++;
        }


    }

    static void simRow(int i) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int j=1; j<=C; j++){
            if(A[i][j]==0) continue;
            map.put(A[i][j], map.getOrDefault(A[i][j], 0)+1);
        }

        map.forEach((x, y)->pq.add(new Node(x, y)));

        int idx=1;
        while(!pq.isEmpty() && idx<=100){
            Node node = pq.poll();
            A[i][idx++]=node.key;
            A[i][idx++]=node.value;
        }
        C = Math.max(C, idx-1);

        while(idx<=99){
            A[i][idx++]=0;
        }
    }

    static void simCol(int i) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int j=1; j<=R; j++){
            if(A[j][i]==0) continue;
            map.put(A[j][i], map.getOrDefault(A[j][i], 0)+1);
        }

        map.forEach((x, y)->pq.add(new Node(x, y)));

        int idx=1;
        while(!pq.isEmpty() && idx<=100){
            Node node = pq.poll();
            A[idx++][i]=node.key;
            A[idx++][i]=node.value;
        }
        R = Math.max(R, idx-1);

        while(idx<=99){
            A[idx++][i]=0;
        }
    }
}
