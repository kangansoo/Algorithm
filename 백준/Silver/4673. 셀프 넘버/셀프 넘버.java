import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] arr = new boolean[10001];
        for(int i=1; i<10001; i++){
            int x=i;
            int n=x;
            while(x!=0){
                n+=x%10;
                x=x/10;
            }
            if(n>=10001) continue;
            arr[n]=true;
        }
        for(int i=1; i<10001; i++){
            if(!arr[i]){
                writer.write(i+"\n");
            }
        }
        writer.flush();
    }
}