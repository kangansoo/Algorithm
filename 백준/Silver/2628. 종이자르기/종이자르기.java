import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(br.readLine());
		
		List<Integer> x = new ArrayList<>();
		List<Integer> y = new ArrayList<>();
		List<Integer> sums = new ArrayList<>();
		x.add(0);
		y.add(0);
		x.add(m); // 끝 좌표를 리스트에 추가합니다.
        y.add(n);
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a==0) {
				y.add(b);
			}else {
				x.add(b);
			}
		}

		Collections.sort(x);
		Collections.sort(y);
		for(int i=1; i<x.size(); i++) {
			for(int j=1; j<y.size(); j++) {
				sums.add((x.get(i)-x.get(i-1))*(y.get(j)-y.get(j-1)));
			}
		}
		System.out.println(Collections.max(sums));
	}
}