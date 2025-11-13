

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static Map<String, Integer> degree = new HashMap<>();
    static Map<String, List<String>> graph = new HashMap<>();
    static Map<String, PriorityQueue<String>> relation = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            String name = st.nextToken();
            degree.put(name, 0);
            graph.put(name, new ArrayList<>());
            relation.put(name, new PriorityQueue<>());
        }

        M = Integer.parseInt(br.readLine());

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            graph.get(b).add(a);
            degree.put(a, degree.get(a)+1);
        }

        Queue<String> q = new LinkedList<>();
        PriorityQueue<String> pq = new PriorityQueue<>();

        for(String name: degree.keySet()) {
            if(degree.get(name)==0) {
                q.add(name);
                pq.add(name);
            }
        }

        sb.append(pq.size()).append("\n");

        while(!pq.isEmpty()) {
            sb.append(pq.poll()).append(" ");
        }
        sb.append("\n");

        while(!q.isEmpty()) {
            String parent = q.poll();
            for(String child:graph.get(parent)) {
                int n = degree.get(child);
                degree.put(child, n-1);
                if(n-1==0) {
                    relation.get(parent).add(child);
                    q.add(child);
                }
            }
        }

        for(String parent:relation.keySet()) {
            StringBuilder family = new StringBuilder();
            PriorityQueue<String> children = relation.get(parent);
            family.append(parent).append(" ").append(children.size()).append(" ");
            while(!children.isEmpty()) {
                family.append(children.poll()).append(" ");
            }
            family.append("\n");
            pq.add(family.toString());
        }

        while(!pq.isEmpty()) {
            sb.append(pq.poll());
        }

        System.out.println(sb);
    }
}
