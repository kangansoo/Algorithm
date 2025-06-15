import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int N;
    static boolean[] visited;
    static int[] numbers;
    static ArrayList<Integer> answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N+1];
        visited = new boolean[N+1];
        answer = new ArrayList<>();

        for(int i=1; i<=N; i++){
            numbers[i] = Integer.parseInt(br.readLine());
        }

        for(int i=1; i<=N; i++){
            visited[i]=true;
            dfs(i, i);
            visited[i]=false;
        }

        System.out.println(answer.size());
        for(int num:answer){
            System.out.println(num);
        }
    }

    static void dfs(int start, int end){
        if(numbers[start] == end){
            answer.add(end);
            return;
        }

        if(!visited[numbers[start]]){
            visited[numbers[start]]=true;
            dfs(numbers[start], end);
            visited[numbers[start]]=false;
        }
    }
}
