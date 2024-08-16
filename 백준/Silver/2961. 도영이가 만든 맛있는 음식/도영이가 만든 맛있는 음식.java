import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] sour, bitter;
	static boolean[] isSelected;
	static int minValue;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		sour = new int[N];
		bitter = new int[N];
		isSelected = new boolean[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sour[i]=a;
			bitter[i]=b;
		}
		
		
		minValue = Integer.MAX_VALUE;
		subset(0);
		System.out.println(minValue);
		
	}
	
	private static void subset(int cnt) {
		
		int sourValue = 1;
		int bitterValue= 0;
		
		int diff = 0;
		if(cnt==N) {
			for(int i=0; i<N; i++) {
				if(isSelected[i]) {
					sourValue *= sour[i];
					bitterValue += bitter[i];
					diff = Math.abs(sourValue-bitterValue);
					if(diff<minValue) minValue=diff;
				}
			}
			return;
		}
		
		isSelected[cnt] = true;
		subset(cnt+1);
		isSelected[cnt] = false;
		subset(cnt+1);
	}
}