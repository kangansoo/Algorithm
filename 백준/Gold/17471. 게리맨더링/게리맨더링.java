import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int minDist = Integer.MAX_VALUE;
    static int N;
    static int[] people;
    static List<Integer>[] adj;
    static boolean[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        people = new int[N+1];
        adj = new ArrayList[N + 1];
        selected = new boolean[N + 1];

        st=new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            people[i]=Integer.parseInt(st.nextToken());
            adj[i] = new ArrayList<>();
        }
        for(int i=1; i<=N; i++){
            st=new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for(int j=0; j<cnt; j++){
                int neighbor = Integer.parseInt(st.nextToken());
                adj[i].add(neighbor);
            }
        }

        divide(1);

        System.out.println(minDist==Integer.MAX_VALUE?-1:minDist);
    }

    static void divide(int depth){
        if(depth==N+1){
            List<Integer> groupA = new LinkedList<>();
            List<Integer> groupB = new LinkedList<>();

            for(int i=1; i<=N; i++){
                if(selected[i]) groupA.add(i);
                else groupB.add(i);
            }

            if(groupA.isEmpty() || groupB.isEmpty()) return;

            if(check(groupA) && check(groupB)){
                int a = calc(groupA);
                int b = calc(groupB);
                int diff = Math.abs(a-b);
                minDist = Math.min(minDist, diff);
            }
            return;
        }
        selected[depth] = true;
        divide(depth+1);
        selected[depth]=false;
        divide(depth+1);
    }

    static boolean check(List<Integer> group){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N+1];

        q.add(group.get(0));
        visited[group.get(0)] = true;
        int visitedCnt = 1;

        while(!q.isEmpty()){
            int curr = q.poll();
            for(int neighbor:adj[curr]){
                if(group.contains(neighbor) && !visited[neighbor]){
                    visited[neighbor]=true;
                    visitedCnt++;
                    q.add(neighbor);
                }
            }
        }

        return visitedCnt == group.size();
    }

    static int calc(List<Integer> group){
        int num=0;
        for(int n:group){
            num+=people[n];
        }
        return num;
    }
}