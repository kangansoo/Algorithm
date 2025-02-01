import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            int N = Integer.parseInt(br.readLine());
            int answer=0;
            int visited = 0;
            int target = (1<<10)-1;
            while(visited!=target){
                answer +=N;
                char[] chr = String.valueOf(answer).toCharArray();
                for(char ch:chr){
                    int num = ch-'0';
                    visited |= (1<<num);
                }
            }
            System.out.println("#"+t+" "+answer);
        }
    }
}