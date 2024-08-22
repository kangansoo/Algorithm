import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int minCost;
    static int[] cost, plan;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            cost = new int[4];
            plan = new int[13];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<4; i++){
                cost[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<13; i++){
                plan[i] = Integer.parseInt(st.nextToken());
            }

            minCost = cost[3];

            backtracking(1, 0);
            sb.append("#").append(t).append(" ").append(minCost).append("\n");
        }
        System.out.println(sb);
    }

    static void backtracking(int month, int sum){
        if(sum>=minCost) return;
        if(month>12){
            minCost=sum;
            return;
        }

        if(plan[month]==0){
            backtracking(month+1, sum);
        }else{
            backtracking(month+1, sum+cost[0]*plan[month]);
            backtracking(month+1, sum+cost[1]);
            backtracking(month+3, sum+cost[2]);
        }

    }
}