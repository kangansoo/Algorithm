import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<int[]> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;  i<N; i++) {
			int value=Integer.parseInt(st.nextToken());
			int[] tmp= {-1,-1};
			while(!stack.isEmpty()) {
				tmp = stack.peek();
				if(tmp[1]>=value) {				
					break;
				}else {
					stack.pop();
				}
			}
			if(stack.isEmpty()) {
				sb.append(0+" ");
			}else {
				sb.append((tmp[0]+1) + " ");
			}
			
			stack.add(new int[] {i, value});
		}
		System.out.println(sb);
	}
}