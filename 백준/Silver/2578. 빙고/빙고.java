
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

	private static int checkBingo(boolean[][] bingoBoard) {
		int N=5;
		int bingoCnt=0;
		boolean[] rowChecked = new boolean[N];
		boolean[] colChecked = new boolean[N];
		boolean crossChecked = false;
		boolean crossChecked2 = false;
		
		for(int i=0; i<N; i++) {
			boolean rowBingo = true;
			for(int j=0; j<N; j++) {
				if(!bingoBoard[i][j]) {
					rowBingo = false;
					break;
				}
			}
			if(rowBingo && !rowChecked[i]) {
				rowChecked[i]=true;
				bingoCnt++;
			}
		}
		for(int j=0; j<N; j++) {
			boolean colBingo = true;
			for (int i=0; i<N; i++) {
				if(!bingoBoard[i][j]) {
					colBingo = false;
					break;
				}
			}
			if(colBingo && !colChecked[j]) {
				colChecked[j]=true;
				bingoCnt++;
			}
		}
		for(int t=0; t<N; t++) {
			boolean crossBingo = true;
			for(int n=0; n<N; n++) {
				if(!bingoBoard[n][n]) {
					crossBingo = false;
					break;
				}
			}
			if(crossBingo && !crossChecked) {
				crossChecked=true;
				bingoCnt++;
			}
		} 
		
		for(int t=0; t<N; t++) {
			boolean crossBingo2 = true;
			for(int n=0; n<N; n++) {
				if(!bingoBoard[n][N-n-1]) {
					crossBingo2 = false;
					break;
				}
			}
			if(crossBingo2 && !crossChecked2) {
				crossChecked2=true;
				bingoCnt++;
			}
		}
		return bingoCnt;
	}
    
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int board[][] = new int [5][5];
		boolean bingoBoard[][] = new boolean[5][5];
		int N = 5;
		int sum=0;
		
		for(int x=0; x<N; x++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int y=0; y<N; y++) {
				board[x][y] = Integer.parseInt(st.nextToken());
			}
		}
		for(int x=0; x<N; x++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int y=0; y<N; y++) {
				int number = Integer.parseInt(st.nextToken());
				sum++;
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						if(board[i][j]==number) {
							bingoBoard[i][j]=true;
						}
					}
				}
				
				int bingoCnt=checkBingo(bingoBoard);
				if(bingoCnt>=3) {
					System.out.println(sum);
					return;
				}
			}
		}
	}

}
