

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] numbers = new int[13];
    static boolean[] visited = new boolean[13];
    static char[][] map = new char[5][9];
    static int[][] pos = new int[13][2];
    static boolean isSolved=false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int idx=1;

        for(int i=0; i<5; i++) {
            String str = br.readLine();
            for(int j=0; j<9; j++) {
                char cha = str.charAt(j);
                map[i][j]=cha;

                if(cha!='.') {
                    if(cha>='A' && cha<='L') {
                        pos[idx][0]=i;
                        pos[idx][1]=j;
                        numbers[idx]=cha-'A'+1;
                        visited[cha-'A'+1]=true;
                    } else if(cha=='x') {
                        pos[idx][0]=i;
                        pos[idx][1]=j;
                    }
                    idx++;
                }
            }
        }

        dfs(1);
    }

    static void dfs(int depth) {
        if(isSolved) return;
        if(depth==13) {
            if(check()) {
                isSolved=true;
                print();
            }
            return;
        }

        if(numbers[depth]!=0) {
            dfs(depth+1);
            return;
        }
        for(int i=1; i<13; i++) {
            if(visited[i]) continue;
            visited[i]=true;
            numbers[depth]=i;
            map[pos[depth][0]][pos[depth][1]] = (char)(i+'A'-1);
            dfs(depth+1);
            numbers[depth]=0;
            map[pos[depth][0]][pos[depth][1]] = 'x';
            visited[i]=false;
        }
    }

    static int sum(int a, int b, int c, int d) {
        return numbers[a]+numbers[b]+numbers[c]+numbers[d];
    }

    static boolean check() {
        return sum(1, 3, 6, 8) == 26 &&
                sum(1, 4, 7, 11) == 26 &&
                sum(2, 3, 4, 5) == 26 &&
                sum(2, 6, 9, 12) == 26 &&
                sum(8, 9, 10, 11) == 26 &&
                sum(5, 7, 10, 12) == 26;
    }

    static void print() {
        for (int i = 0; i < 5; i++) {
            System.out.println(new String(map[i]));
        }
    }
}
