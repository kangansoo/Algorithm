import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(a==1) {
				for(int i=b-1; i<N; i+=b) {
					arr[i]=(arr[i]==0)?1:0;
				}
			} else if (a==2) {
				int center = b-1;
				arr[center]= (arr[center]==0)?1:0;
				int left = center-1;
				int right = center+1;
				while(left>=0 && right<N && arr[left]==arr[right]) {
					arr[left]=(arr[left]==0)?1:0;
					arr[right]=(arr[right]==0)?1:0;
					left--;
					right++;
				}
			}
		}
		for(int i=0; i<N; i++) {
			if(i>0 && (i+1)%20!=1) {
				System.out.print(" ");
			}
			System.out.print(arr[i]);
			if((i+1)%20==0){
				System.out.println();
			}
		}
	}
}