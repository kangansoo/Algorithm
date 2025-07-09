import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int N, D;
    static int[] dist;
    static List<List<Edge>> graph;
    static class Edge implements Comparable<Edge> {
        int to;
        int cost;
        public Edge (int to, int cost){
            this.to = to;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge o){
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        // 배열 / 인접 리스트 초기화
        dist = new int[D+1];
        graph = new ArrayList<>();

        Arrays.fill(dist, INF);
        for(int i=0; i<=D; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if(to>D) continue; // 도착 지점보다 멀리 가는 지름길은 기록X
            graph.get(from).add(new Edge(to, cost));
        }

        dijkstra();

        System.out.println(dist[D]);
    }

    static void dijkstra(){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0, 0)); // 0에서 시작
        dist[0] = 0;

        while(!pq.isEmpty()){
            Edge curr = pq.poll(); // 현재 위치
            int currV = curr.to;
            int currC = curr.cost; // 현재까지 이동 거리

            // 이미 기록된 이동 거리와 비교. -> 이미 더 적은 값이 저장되어 있으면 넘기기
            if(currC>dist[currV]) continue;

            // 지름길 이동
            for(Edge next:graph.get(currV)){
                int newDist = currC + next.cost;
                if(newDist<dist[next.to]){
                    dist[next.to] = newDist;
                    pq.add(new Edge(next.to, newDist));
                }
            }

            // 한 칸 이동
            if(currV+1<=D){
                if(dist[currV+1]>currC+1){
                    dist[currV+1]=currC+1;
                    pq.add(new Edge(currV+1, currC+1));
                }
            }
        }
    }
}
