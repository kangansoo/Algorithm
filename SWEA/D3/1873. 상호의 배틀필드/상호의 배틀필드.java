import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int x, y, W, H, direction;
	static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static char[][] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			arr = new char[H][W];
			
			x=0; y=0;
			
			for(int i=0; i<H; i++) {
				String str = br.readLine();
				for(int j=0; j<W; j++) {
					arr[i][j]=str.charAt(j);
					if(arr[i][j]=='>' || arr[i][j]=='<' || arr[i][j]=='^' || arr[i][j]=='v') {
						x=i;
						y=j;
					}
				}
			}
			
			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();
			char[] commend = new char[N];
			for(int i=0; i<N; i++) {
				commend[i]=str.charAt(i);
			}
			for(char c:commend) {
				switch(c) {
					case'R':
						arr[x][y]='>';
						move(arr[x][y]);
						break;
					case'D':
						arr[x][y]='v';
						move(arr[x][y]);
						break;
					case'L':
						arr[x][y]='<';
						move(arr[x][y]);
						break;
					case'U':
						arr[x][y]='^';
						move(arr[x][y]);
						break;
					case'S':
						shoot(x, y);
						break;
				}
			}
			
			for(char[]a:arr) {
				for(char ch:a) {
					sb.append(ch);
				}
				sb.append("\n");
			}
		}
		
		System.out.println(sb);
		
	}
	
	static int findDir(char comm) {
		direction = -1;
		switch(comm) {
			case '>':
				direction = 0;
				break;
			case 'v':
				direction = 1;
				break;
			case '<':
				direction = 2;
				break;
			case '^':
				direction = 3;
				break;
		}
		return direction;
	}
	
	static void shoot(int x, int y) {
		int dir = findDir(arr[x][y]);
		int nx = x+deltas[dir][0];
		int ny = y+deltas[dir][1];
		
		while (nx >= 0 && nx < H && ny >= 0 && ny < W) {
	        if (arr[nx][ny] == '*') {
	            arr[nx][ny] = '.';
	            return;
	        } else if (arr[nx][ny] == '#') {
	            return;
	        } else if (arr[nx][ny] == '-' || arr[nx][ny] == '.') {
	            nx += deltas[dir][0];
	            ny += deltas[dir][1];
	        }
	    }
	}
	
	static void move(char comm) {
		int dir = findDir(comm);
		int nx = x+deltas[dir][0];
		int ny = y+deltas[dir][1];
		
		if(nx<0 || nx>=H || ny<0 || ny>=W) return;
		if(arr[nx][ny]!='.') return;
		arr[nx][ny] = arr[x][y];
        arr[x][y] = '.';
        x = nx;
        y = ny;
	}
}