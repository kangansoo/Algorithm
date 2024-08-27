import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int L, C;
	static char[] passwords, arr;
	static boolean[] isSelected;
	static char[] vowels = {'a', 'e', 'i', 'o', 'u'};
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		passwords = new char[L];
		arr = new char[C];
		isSelected = new boolean[C];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<C; i++) {
			arr[i]=st.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		
		comb(0, 0, 0, 0);
		
		System.out.println(sb);
	}
	
	static void comb(int cnt, int start, int vowCnt, int conCnt) {
		if(cnt==L) {
			if(vowCnt>=1 && conCnt>=2) {
				for(int i=0; i<L; i++) {
					sb.append(passwords[i]);
				}
				sb.append("\n");
			}
			return;
		}
		for(int i=start; i<C; i++) {
			if(isSelected[i]) continue;
			passwords[cnt]=arr[i];
			if(isVowel(arr[i])) {
				comb(cnt+1, i+1, vowCnt+1, conCnt);
			}else {
				comb(cnt+1, i+1, vowCnt, conCnt+1);
			}
		}
	}
	
	static boolean isVowel(char ch) {
		for(char v:vowels) {
			if(v==ch) return true;
		}
		return false;
	}

}
