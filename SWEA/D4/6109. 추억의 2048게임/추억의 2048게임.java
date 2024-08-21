import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {

    static int N;
    static String str;
    static int[][] map;
    static Deque<Integer> temp;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	StringBuilder sb = new StringBuilder();
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
        	sb.append("#").append(t).append("\n");
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            str = st.nextToken();
            map = new int[N][N];
            
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            switch (str) {
                case "up":
                    up();
                    break;
                case "down":
                    down();
                    break;
                case "left":
                    left();
                    break;
                case "right":
                    right();
                    break;
            }
            

            for(int x=0; x<N; x++) {
            	for(int y=0; y<N; y++) {
            		sb.append(map[x][y]).append(" ");
            	}
            	sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    static void up() {
    	for (int y = 0; y < N; y++) {
        	temp = new LinkedList<Integer>();
    		for(int x=0; x<N; x++) {
    			temp.add(map[x][y]);
    		}
			move(temp);
			for(int x=0; x<N; x++) {
				map[x][y]=temp.pollFirst();
			}
    	}
    }

    static void down() {
    	for (int y = 0; y < N; y++) {
        	temp = new LinkedList<Integer>();
    		for(int x=N-1; x>=0; x--) {
    			temp.add(map[x][y]);
    		}
			move(temp);
			for(int x=N-1; x>=0; x--) {
				map[x][y]=temp.pollFirst();
			}
    	}
    }

    static void left() {
    	for (int x = 0; x < N; x++) {
        	temp = new LinkedList<Integer>();
    		for(int y=0; y<N; y++) {
    			temp.add(map[x][y]);
    		}
			move(temp);
			for(int y=0; y<N; y++) {
				map[x][y]=temp.pollFirst();
			}
    	}
    }

    static void right() {
    	for (int x = 0; x < N; x++) {
        	temp = new LinkedList<Integer>();
    		for(int y=N-1; y>=0; y--) {
    			temp.add(map[x][y]);
    		}
			move(temp);
			for(int y=N-1; y>=0; y--) {
				map[x][y]=temp.pollFirst();
			}
    	}
    }
    
    static void move(Deque<Integer> temp) {
    	int cnt = 0;
    	for(int i=0; i<N; i++) {
    		int v = temp.pollFirst();
    		if(v==0) {
    			cnt++;
    		}else {
    			temp.add(v);
    		}
    	}
    	int k = temp.size();
    	for(int i=0; i<k; i++) {
    		if(i==k-1) {
    			temp.addLast(temp.pollFirst());
    		}else {
    			int v = temp.pollFirst();
        		
        		if(v==0) {
        			cnt++;
        		}else {
        			int vv = temp.pollFirst();
        			if(v==vv) {
        				temp.addLast(v*2);
        				temp.addFirst(0);
        			} else {
        				temp.addLast(v);
        				temp.addFirst(vv);
        			}
        		}
    		}
    	}
		for(int j=0; j<cnt; j++) {
    		temp.add(0);
    	}
    }
}