class Solution {
    public int solution(int n) {
        int answer = 1;
        int l=1, r=2;
        int sum = l+r;
        
        while(r<n) {
            if(sum==n) {
                answer++;
                r++;
                sum+=r;
            } else if(sum>n) {
                sum-=l;
                l++;
            } else if(sum<n) {
                r++;
                sum+=r;
            }
        }
        
        return answer;
    }
}