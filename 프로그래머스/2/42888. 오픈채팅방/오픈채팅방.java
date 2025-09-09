import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        List<String[]> list = new ArrayList<>();
        
        for(String rec:record) {
            String[] mes = rec.split(" ");
            String comm = mes[0];
            String uid = mes[1];
            
            if(comm.equals("Enter")) {
                map.put(uid, mes[2]);
                list.add(new String[]{comm, uid});
            } else if(comm.equals("Leave")) {
                list.add(new String[]{comm, uid});
            } else if(comm.equals("Change")) {
                map.put(uid, mes[2]);
            }
        }
        
        String[] answer = new String[list.size()];
        
        int idx=0;
        for(String[] log:list) {
            String comm = log[0];
            String uid = log[1];
            String nick = map.get(uid);
            
            if(comm.equals("Enter")) {
                answer[idx++] = nick+"님이 들어왔습니다.";
            } else {
                answer[idx++] = nick+"님이 나갔습니다.";
            }
        }
        
        
        return answer;
    }
}