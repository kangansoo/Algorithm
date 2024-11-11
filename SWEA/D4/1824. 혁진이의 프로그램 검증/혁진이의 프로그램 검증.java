import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int R, C;
	static char[][] map;
	static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 우, 하, 좌, 상
	static boolean[][][][] visited;
	static StringBuilder sb;
	static String answer;
	static boolean findAnswer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        
        for(int t=1; t<=T; t++) {
        	sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            
            findAnswer=false;
            map = new char[R][C];
            visited = new boolean[R][C][4][16];
            boolean hasResult=false;
            for(int i=0; i<R; i++) {
            	String str = br.readLine();
            	for(int j=0; j<C; j++) {
            		map[i][j] = str.charAt(j);
            		if(map[i][j]=='@') hasResult=true;
            	}
            }
            
            if(!hasResult) {
            	sb.append("NO").append("\n");
            } else {
            	dfs(0, 0, 0, 0);
                sb.append(findAnswer?"YES":"NO").append("\n");
            }
        }
        System.out.println(sb);
	}
	
	static void dfs(int x, int y, int dir, int mem) {
		if(findAnswer) {
			return;
		}
		if(map[x][y]=='@') {
			findAnswer=true;
			return;
		}
		if(visited[x][y][dir][mem]) {
			return;
		}
		if(map[x][y]=='?') {
			for(int i=0; i<=3; i++) {
				visited[x][y][i][mem]=true;
			}
		}
		visited[x][y][dir][mem]=true;
		
		if(map[x][y]=='?') {
			for(int d=0; d<4; d++) {
				int nx = (x + deltas[d][0] + R) % R;
				int ny = (y + deltas[d][1] + C) % C;
				dfs(nx, ny, d, mem);
			}
		} else {
			int nd = dir;
			int nm = mem;
			switch(map[x][y]) {
	    		case 'v':
	    			nd = 1;
	    			break;
	    		case '>':
	    			nd=0;
	    			break;
	    		case '<':
	    			nd=2;
	    			break;
	    		case '^':
	    			nd=3;
	    			break;
	    		case '_':
	    			nd = (mem==0?0:2);
	    			break;
	    		case '|':
	    			nd = (mem==0?1:3);
	    			break;
	    		case '-':
	    			nm = (mem-1+16)%16;
	    			break;
	    		case '+':
	    			nm = (mem+1)%16;
	    			break;
	    		default:
                    if(map[x][y]>='0' && map[x][y]<='9') {
                        nm = map[x][y]-'0';
                    }
                    break;
			}
			int nx = (x + deltas[nd][0] + R) % R;
			int ny = (y + deltas[nd][1] + C) % C;
			dfs(nx, ny, nd, nm);
		}
	}

}