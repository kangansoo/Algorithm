class Solution {
    static int cnt=0, answer;
    static String str="AEIOU";
    public int solution(String word) {
        answer=0;
        perm(0, word, "", str);
        return answer;
    }
    
    static void perm(int depth, String word, String curr, String str) {
        if(depth>5) {
            return;
        }
        if(curr.length()>0){
            cnt++;
            if(curr.equals(word)) {
                answer=cnt;
                return;
            }
        }
        for(int i=0; i<str.length(); i++) {
            perm(depth+1, word, curr+str.charAt(i), str);
        }
    }
}