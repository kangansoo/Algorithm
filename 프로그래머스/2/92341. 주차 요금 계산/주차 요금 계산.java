import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> ins = new HashMap<>();
        Map<String, Integer> map = new TreeMap<>();
        
        for(String str:records) {
            String[] record = str.split(" ");
            int time = timeToMin(record[0]);
            String number = record[1];
            String type = record[2];
            
            if(type.equals("IN")) {
                ins.put(number, ins.getOrDefault(number, 0)+time);
            } else {
                int inTime = ins.remove(number);
                int duration = time-inTime;
                map.put(number, map.getOrDefault(number, 0)+duration);
            }
        }
        
        int dayOff = timeToMin("23:59");
        for(String key:ins.keySet()) {
            int duration = dayOff - ins.get(key);
            map.put(key, map.getOrDefault(key, 0)+duration);
        }
        
        int[] answer = new int[map.size()];
        
        int idx=0;
        for(int time:map.values()) {
            if(time<=fees[0]){
                answer[idx++] = fees[1];
            } else {
                int tmp = time-fees[0];
                int extra = (int)Math.ceil((double)tmp/fees[2])*fees[3];
                answer[idx++] = fees[1]+extra;
            }
        }
        
        return answer;
    }
    
    public int timeToMin(String str) {
        String[] time = str.split(":");
        int hour = Integer.parseInt(time[0]);
        int min = Integer.parseInt(time[1]);
        return hour*60+min;
    }
}