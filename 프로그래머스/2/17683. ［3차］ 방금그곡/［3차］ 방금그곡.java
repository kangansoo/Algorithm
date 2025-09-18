class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxTime = 0;
        String target = convert(m);
        
        for(String music:musicinfos) {
            String[] info = music.split(",");
            String[] startT = info[0].split(":");
            String[] endT = info[1].split(":");
            String title = info[2];
            String melody = convert(info[3]);
            
            int time = (Integer.parseInt(endT[0])*60+Integer.parseInt(endT[1]))-(Integer.parseInt(startT[0])*60+Integer.parseInt(startT[1]));
            
            int tmp = melody.length();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<time; i++) {
                sb.append(melody.charAt(i%tmp));
            }
            
            if(sb.toString().contains(target)) {
                if(time>maxTime) {
                    maxTime=time;
                    answer=title;
                }
            }
            
        }
        
        return answer;
    }
    
    static String convert(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if(i+1<str.length() && str.charAt(i+1)=='#') {
                sb.append(Character.toLowerCase(c));
                i++;
            } else {
                sb.append(c);
            }
        }  
        
        return sb.toString();
    }
}