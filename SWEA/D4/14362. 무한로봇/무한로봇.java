import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    static int maxLength;
    static int[][] deltas={{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
    static boolean inf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            sb.append("#").append(t).append(" ");
            maxLength=0;
            inf = true;
            String str = br.readLine().trim();

            int x = 0;
            int y = 0;
            int dir = 0;
            for(int i=0; i<4; i++){
                for(int j=0; j<str.length(); j++){
                    char comm = str.charAt(j);
                    switch(comm){
                        case 'S':
                            x+=deltas[dir][0];
                            y+=deltas[dir][1];
                            break;
                        case 'L':
                            dir = (dir+1)%4;
                            break;
                        case 'R':
                            dir = (dir+3)%4;
                            break;
                    }
                    maxLength = Math.max(maxLength, x*x+y*y);
                }
            }
            if(x==0 && y==0 && dir==0) inf=false;
            if(inf){
                sb.append("oo").append("\n");
            }else{
                sb.append(maxLength).append("\n");
            }
        }

        System.out.println(sb);
    }
}