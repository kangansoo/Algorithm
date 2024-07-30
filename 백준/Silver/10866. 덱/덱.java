import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] queue = new int[n];
		int size = 0;
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			switch(str) {
				case "push_front":
					int v = Integer.parseInt(st.nextToken());
					for(int j=size-1; j>=0; j--) {
						queue[j+1]=queue[j];
					}
					queue[0]=v;
					size++;
					break;
				case "push_back":
					int v1 = Integer.parseInt(st.nextToken());
					queue[size++]=v1;
					break;
				case "pop_front":
					if(size==0) {
						System.out.println(-1);
					}else {
						System.out.println(queue[0]);
						for(int j=1; j<size; j++) {
							queue[j-1]=queue[j];
						}
						size--;
					}
					break;
				case "pop_back":
					if(size==0) {
						System.out.println(-1);
					}else {
						System.out.println(queue[size-1]);
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
				case "front":
					if(size==0) {
						System.out.println(-1);
					}else {
						System.out.println(queue[0]);
					}
					break;
				case "back":
					if(size==0) {
						System.out.println(-1);
					}else {
						System.out.println(queue[size-1]);
					}
					break;
			}
		}
	}
}
