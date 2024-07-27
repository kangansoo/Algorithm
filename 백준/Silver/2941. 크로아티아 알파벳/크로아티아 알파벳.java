import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String word = reader.readLine();
        String[] arr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for(String i:arr){
            word = word.replace(i,"0");
        }
        System.out.println(word.length());
    }
}