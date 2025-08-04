import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static Map<String, Integer> degree;
    static Map<String, List<String>> graph;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        degree = new HashMap<>();
        graph = new HashMap<>();

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());
            graph.get(a).add(b);

            degree.putIfAbsent(a, 0);
            degree.putIfAbsent(b, 0);
            degree.put(b, degree.get(b)+1);
        }

        topology();
    }

    static void topology() {
        Queue<String> q = new LinkedList<>();
        List<String> nodes = new ArrayList<>();
        int cnt=0;
        for(String str:degree.keySet()) {
            if(degree.get(str)==0) {

                nodes.add(str);
            }
        }

        Collections.sort(nodes);
        for(String node:nodes) {
            q.add(node);
        }

        while(!q.isEmpty()) {
            List<String> nodes2 = new ArrayList<>();
            int size = q.size();
            for(int i=0; i<size; i++) {
                cnt++;
                String curr = q.poll();
                sb.append(curr).append("\n");

                for(String str:graph.get(curr)) {
                    degree.put(str, degree.get(str)-1);
                    if(degree.get(str)==0) {
                        nodes2.add(str);
                    }
                }
            }
            Collections.sort(nodes2);
            for(String node:nodes2) {
                q.add(node);
            }
        }

        if(cnt==degree.size()) {
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }
    }
}
