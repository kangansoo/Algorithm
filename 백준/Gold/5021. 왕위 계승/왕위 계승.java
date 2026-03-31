

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String king = br.readLine();

        Map<String, Integer> idx = new HashMap<>();
        List<String[]> info = new ArrayList<>();

        for(int i=0; i<N; i++) {
            String[] str = br.readLine().split(" ");
            info.add(str);
            for(String s:str) {
                if(!idx.containsKey(s)) {
                    idx.put(s, idx.size());
                }
            }
        }

        String[] candidates = new String[M];
        for(int i=0; i<M; i++) {
            String c = br.readLine();
            candidates[i]=c;
            if(!idx.containsKey(c)) {
                idx.put(c, idx.size());
            }
        }

        int size = idx.size();
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[size];
        double[] blood = new double[size];

        for(int i=0; i<size; i++) {
            adj.add(new ArrayList<>());
        }

        for(String[] i:info) {
            int c = idx.get(i[0]);
            int p1 = idx.get(i[1]);
            int p2 = idx.get(i[2]);

            adj.get(p1).add(c);
            adj.get(p2).add(c);
            indegree[c] = 2;
        }

        blood[idx.get(king)] = 1.0;

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<size; i++) {
            if(indegree[i]==0) q.add(i);
        }

        while(!q.isEmpty()) {
            int curr = q.poll();
            for(int next:adj.get(curr)) {
                blood[next] += blood[curr]/2.0;
                indegree[next]--;

                if(indegree[next]==0) {
                    q.add(next);
                }
            }
        }

        String heir = "";
        double max = -1.0;

        for(int i=0; i<M; i++) {
            if(blood[idx.get(candidates[i])]>max) {
                heir=candidates[i];
                max=blood[idx.get(candidates[i])];
            }
        }

        System.out.println(heir);
        br.close();
    }
}
