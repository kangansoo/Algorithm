import java.io.*;
import java.util.*;

class Solution {
    static int N, X, M;
    static int[][] records;
    static int[] cages;
    static int[] answer;
    static int maxSum;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            records = new int[M][3];
            cages = new int[N];
            answer = new int[N];
            maxSum = -1;

            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                records[i][0] = Integer.parseInt(st.nextToken())-1;
                records[i][1] = Integer.parseInt(st.nextToken())-1;
                records[i][2] = Integer.parseInt(st.nextToken());
            }

            dfs(0);
            if(maxSum==-1){
                sb.append(-1).append("\n");
            }else{
                for(int a:answer){
                    sb.append(a).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    static void dfs(int depth){
        if(depth == N){
            if(isValid()){
                int sum=0;
                for(int i:cages){
                    sum+=i;
                }
                if(sum>maxSum || (sum == maxSum && dict())){
                    maxSum=sum;
                    answer = Arrays.copyOf(cages, N);
                }
            }
            return;
        }

        for(int i=0; i<=X; i++) {
            cages[depth]=i;
            dfs(depth+1);
        }
    }

    static boolean isValid(){
        for(int[] record:records){
            int sum=0;
            for(int i=record[0]; i<=record[1]; i++){
                sum+=cages[i];
            }
            if(sum!=record[2]) return false;
        }
        return true;
    }

    static boolean dict(){
        for(int i=0; i<N; i++){
            if(cages[i]<answer[i]) return true;
            if(cages[i]>answer[i]) return false;
        }
        return false;
    }
}