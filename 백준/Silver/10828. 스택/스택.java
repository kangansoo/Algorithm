import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void  main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] stack = new int[n];
		int size = 0;
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			switch(str) {
				case "push":
					int v = Integer.parseInt(st.nextToken());
					stack[size++]=v;
					break;
				case "top":
					if(size==0) {
						System.out.println(-1);
					}else {
						System.out.println(stack[size-1]);
					}
					break;
				case "pop":
					if(size==0) {
						System.out.println(-1);
					}else {
						System.out.println(stack[size-1]);
						size--;
					}
					break;
				case "size":
					System.out.println(size);
					break;
				case "empty":
					if(size==0) {
						System.out.println(1);
					}else {
						System.out.println(0);
					}
					break;
			}
		}
	}
}