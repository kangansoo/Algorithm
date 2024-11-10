import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N, M, C, answer, maxNum;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            answer = 0;

            map = new int[N][N];
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<=N-M; j++){
                    int first = getBenefit(i, j);

                    for(int y=j+M; y<=N-M; y++){
                        int second = getBenefit(i, y);
                        answer = Math.max(answer, first+second);
                    }

                    for(int x=i+1; x<N; x++){
                        for(int y=0; y<=N-M; y++){
                            int second = getBenefit(x, y);
                            answer = Math.max(answer, first+second);
                        }
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static int getBenefit(int x, int y){
        maxNum=0;
        maxBenefit(x, y, 0, 0, 0);
        return maxNum;
    }

    static void maxBenefit(int x, int y, int depth, int sum, int squareSum){
        if(depth==M){
            if(sum<=C){
                maxNum=Math.max(maxNum, squareSum);
            }
            return;
        }
        maxBenefit(x, y+1, depth+1, sum+map[x][y], squareSum+map[x][y]*map[x][y]);
        maxBenefit(x, y+1, depth+1, sum, squareSum);
    }
}