import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        StringTokenizer st;
        int[] answer = new int[2];
        
        PriorityQueue<Integer> maxH = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minH = new PriorityQueue<>();
        
        for(int i=0; i<operations.length; i++) {
            st = new StringTokenizer(operations[i]);
            String op = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            switch(op) {
                case "I":
                    minH.add(num);
                    maxH.add(num);
                    break;
                case "D":
                    if(num==-1) {
                        if(minH.size()>0){
                            int tmp = minH.poll();
                            maxH.remove(tmp);
                        }
                    } else {
                        if(maxH.size()>0){
                            int tmp = maxH.poll();
                            minH.remove(tmp);
                        }
                    }
                    break;
            }
        }
        
        if(minH.isEmpty() && maxH.isEmpty()) {
            answer[0]=0;
            answer[1]=0;
        } else {
            answer[0]=maxH.poll();
            answer[1]=minH.poll();
        }
        
        return answer;
    }
}