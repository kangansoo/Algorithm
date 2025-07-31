import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int[] numbers = {1, 5, 10, 50, 100, 500, 1000};
    static final char[] alphabets = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        int sum = changeToNumber(str1)+changeToNumber(str2);

        System.out.println(sum);

        System.out.println(changeToString(sum));
    }

    static int changeToNumber(String str) {
        int num=0;
        int prev = 0;
        for(int i=0; i<str.length(); i++){
            for(int j=0; j<alphabets.length; j++) {
                if(str.charAt(i)==alphabets[j]){
                    int curr = numbers[j];
                    if(curr>prev) {
                        num+=(curr-prev*2);
                    } else {
                        num+=curr;
                    }
                    prev = curr;
                }
            }
        }
        return num;
    }

    static String changeToString(int num) {
        int[] values =    {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols ={"M", "CM", "D", "CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }
}
