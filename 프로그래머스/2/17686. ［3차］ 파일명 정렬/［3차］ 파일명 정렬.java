import java.util.*;

class Solution {
    public class File {
        int idx;
        String original;
        String head;
        int num;
        File(int idx, String original, String head, int num) {
            this.idx=idx;
            this.original=original;
            this.head=head;
            this.num=num;
        }
    }
    public String[] solution(String[] files) {
        int n = files.length;
        File[] fileList = new File[n];
        
        for(int i=0; i<n; i++) {
            String curr = files[i];
            int len = curr.length();
            
            int j=0;
            while(j<len && !Character.isDigit(curr.charAt(j))){
                j++;
            }
            
            int k=j;
            while(k<len && Character.isDigit(curr.charAt(k))) {
                k++;
            }
            
            String head = curr.substring(0, j);
            int num = 0;
            if(k>j) {
                num=Integer.parseInt(curr.substring(j, k));    
            }
            
            fileList[i] = new File(i, curr, head.toUpperCase(), num);
        }
        
        Arrays.sort(fileList, (a, b)->{
            if(!a.head.equals(b.head)) return a.head.compareTo(b.head);
            if(a.num != b.num) return a.num-b.num;
            return a.idx-b.idx;
        });
        
        String[] answer = new String[n];
        
        int idx=0;
        for(File curr:fileList) {
            answer[idx++] = curr.original;
        }
        return answer;
    }
}