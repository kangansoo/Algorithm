import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] parents;
	static int N, M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
        	sb.append("#").append(t).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            parents = new int[N+1];
            
            make();
            for(int i=0; i<M; i++) {
            	st = new StringTokenizer(br.readLine());
            	int a = Integer.parseInt(st.nextToken());
            	int b = Integer.parseInt(st.nextToken());
            	int c = Integer.parseInt(st.nextToken());
            	
            	switch(a) {
            	case 0:
            		union(b, c);
            		break;
            	case 1:
            		int x = findSet(b);
            		if(x == findSet(c)) {
            			sb.append(1);
            		}else {
            			sb.append(0);
            		}
            		break;
            			
            	}
            	
            }
            sb.append("\n");
        }
        System.out.println(sb);
        
	}
	
	static void make() {
		for(int i=0; i<=N; i++) {
			parents[i]=i; // make-set(i) : 자신의 부모를 자신으로 하여 대표자가 되도록 설정
		}
	}
	
	static int findSet(int a) {
		if(a==parents[a]) return a; // 자신이 자신의 부모라면 루트노드이고 집합의 대표자
		
		return parents[a] = findSet(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false; // 두 집합의 대표자가 같으면 이미 같은 집합이므로 합집합 연산 불가
		
		// aRoot에 bRoot를 흡수 : 두 집합 합치기
		parents[bRoot] = aRoot;
		
		return true;
	}

}