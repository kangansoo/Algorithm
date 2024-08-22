import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, R;
    static int[][] map, temp;
    static Queue<Integer> layer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 입력 변수 초기화
        M = Integer.parseInt(st.nextToken()); // 입력 변수 초기화
        R = Integer.parseInt(st.nextToken()); // 입력 변수 초기화
        int[] commends = new int[R];
        map = new int[N][M]; // 입력 배열 초기화
        temp = new int[N][M]; // 입력 배열 초기화

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<R; i++){
            commends[i]=Integer.parseInt(st.nextToken());
        }

        for(int c:commends){
            switch (c){
                case 1:
                    commOne();
                    break;
                case 2:
                    commTwo();
                    break;
                case 3:
                    commThree();
                    break;
                case 4:
                    commFour();
                    break;
                case 5:
                    commFive();
                    break;
                case 6:
                    commSix();
                    break;
            }
        }


        for(int[] m:map){
            for(int a:m){
                System.out.print(a+" ");
            }
            System.out.println();
        }
    }

    static void commOne(){
        int row = map.length;
        int col = map[0].length;
        layer = new LinkedList<>();
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                layer.add(map[i][j]);
            }
        }
        for(int i=row-1; i>=0; i--){
            for(int j=0; j<col; j++){
                map[i][j] = layer.poll();
            }
        }
    }

    static void commTwo(){
        int row = map.length;
        int col = map[0].length;
        layer = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = col - 1; j >= 0; j--) {
                layer.add(map[i][j]);
            }
        }
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                map[i][j] = layer.poll();
            }
        }
    }
    static void commThree(){
        layer = new LinkedList<>();
        int row = map.length;
        int col = map[0].length;
        temp = new int[col][row];

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                temp[j][row-1-i]=map[i][j];
            }
        }
        map=temp;
    }

    static void commFour(){
        layer = new LinkedList<>();
        int row = map.length;
        int col = map[0].length;
        temp = new int[col][row];

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                temp[col-1-j][i]=map[i][j];
            }
        }
        map=temp;
    }

    static void commFive() {
        int row = map.length;
        int col = map[0].length;
        int rowHalf = row/2;
        int colHalf = col/2;
        layer = new LinkedList<>();
        temp = new int[row][col];

        // 추출
        for(int i=0; i<rowHalf; i++) {
            for(int j=0; j<colHalf; j++) {
                layer.add(map[i][j]);
            }
        }
        for(int i=0; i<rowHalf; i++) {
            for(int j=colHalf; j<col; j++) {
                layer.add(map[i][j]);
            }
        }
        for(int i=rowHalf; i<row; i++) {
            for(int j=colHalf; j<col; j++) {
                layer.add(map[i][j]);
            }
        }
        for(int i=rowHalf; i<row; i++) {
            for(int j=0; j<colHalf; j++) {
                layer.add(map[i][j]);
            }
        }

        // 삽입
        for(int i=0; i<rowHalf; i++) {
            for(int j=colHalf; j<col; j++) {
                temp[i][j] = layer.poll();
            }
        }
        for(int i=rowHalf; i<row; i++) {
            for(int j=colHalf; j<col; j++) {
                temp[i][j] = layer.poll();
            }
        }
        for(int i=rowHalf; i<row; i++) {
            for(int j=0; j<colHalf; j++) {
                temp[i][j] = layer.poll();
            }
        }
        for(int i=0; i<rowHalf; i++) {
            for(int j=0; j<colHalf; j++) {
                temp[i][j] = layer.poll();
            }
        }
        map=temp;
    }

    static void commSix() {
        int row = map.length;
        int col = map[0].length;
        int rowHalf = row/2;
        int colHalf = col/2;
        layer = new LinkedList<>();
        temp = new int[row][col];

        // 추출
        for(int i=0; i<rowHalf; i++) {
            for(int j=0; j<colHalf; j++) {
                layer.add(map[i][j]);
            }
        }
        for(int i=0; i<rowHalf; i++) {
            for(int j=colHalf; j<col; j++) {
                layer.add(map[i][j]);
            }
        }
        for(int i=rowHalf; i<row; i++) {
            for(int j=colHalf; j<col; j++) {
                layer.add(map[i][j]);
            }
        }
        for(int i=rowHalf; i<row; i++) {
            for(int j=0; j<colHalf; j++) {
                layer.add(map[i][j]);
            }
        }

        // 삽입
        for(int i=rowHalf; i<row; i++) {
            for(int j=0; j<colHalf; j++) {
                temp[i][j] = layer.poll();
            }
        }
        for(int i=0; i<rowHalf; i++) {
            for(int j=0; j<colHalf; j++) {
                temp[i][j] = layer.poll();
            }
        }
        for(int i=0; i<rowHalf; i++) {
            for(int j=colHalf; j<col; j++) {
                temp[i][j] = layer.poll();
            }
        }
        for(int i=rowHalf; i<row; i++) {
            for(int j=colHalf; j<col; j++) {
                temp[i][j] = layer.poll();
            }
        }
        map=temp;
    }
}