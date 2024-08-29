import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int V;
	static int[] parents;
	
	static class Edge implements Comparable<Edge>{
		int start, end, weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			Edge[] edges = new Edge[E];
			
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				edges[i] = new Edge(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()));
			}
			Arrays.sort(edges);
			make();
			int cnt=0;
			long cost=0;
			for(Edge e:edges) {
				if(union(e.start, e.end)) {
					cost+=e.weight;
					if(++cnt==V-1)break;
				}
			}
			sb.append(cost).append("\n");
		}
		System.out.println(sb);
	}

	static void make() {
		parents = new int[V];
		for(int i=0; i<V; i++) {
			parents[i]=-1;
		}
	}
	
	static int findSet(int a) {
		if(parents[a]<0) return a;
		return parents[a]=findSet(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) return false;
		parents[aRoot]+=parents[bRoot];
		parents[bRoot]=aRoot;
		return true;
	}
}