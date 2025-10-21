import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[][] map=new int[9][9];
    static List<int[]> blanks = new ArrayList<>();
    static boolean solved=false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<9; i++) {
            String str = br.readLine();
            for(int j=0; j<9; j++) {
                int n = str.charAt(j)-'0';
                map[i][j]=n;
                if(n==0) blanks.add(new int[]{i, j});
            }
        }
        dfs(0);
    }

    static void dfs(int depth) {
        if(solved) return;
        if(depth==blanks.size()) {
            solved=true;
            print();
            return;
        }

        int[] curr = blanks.get(depth);
        int x = curr[0];
        int y = curr[1];

        for(int i=1; i<=9; i++) {
            if(!isAvailable(x, y, i)) continue;
            map[x][y]=i;
            dfs(depth+1);
            map[x][y]=0;
        }
    }

    static boolean isAvailable(int x, int y, int n) {
        for(int i=0; i<9; i++) {
            if(map[x][i]==n || map[i][y]==n) return false;
        }

        int tx=(x/3)*3;
        int ty=(y/3)*3;

        for(int i=tx; i<tx+3; i++) {
            for(int j=ty; j<ty+3; j++) {
                if(map[i][j]==n) return false;
            }
        }

        return true;
    }

    static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
