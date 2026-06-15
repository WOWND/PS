class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int vEnd = getMins(video_len);
        int cur = getMins(pos);
        int opStart = getMins(op_start);
        int opEnd = getMins(op_end);
        
        for(String c : commands){
            if(c.equals("next")){
                if(cur >= opStart && cur <=opEnd){
                    cur = opEnd;
                }
                cur = Math.min(vEnd,cur+10);
                if(cur >= opStart && cur <=opEnd){
                    cur = opEnd;
                }
            }else if(c.equals("prev")){
                if(cur >= opStart && cur <=opEnd){
                    cur = opEnd;
                }
                cur = Math.max(0,cur-10);
                if(cur >= opStart && cur <=opEnd){
                    cur = opEnd;
                }
            }
            
        }
        
        int min = cur/60;
        int sec = cur%60;
        
        return String.format("%02d:%02d",min,sec);
    }
    
    public int getMins(String time){
        String[] ts = time.split(":");
        int hour = Integer.parseInt(ts[0]);
        int min = Integer.parseInt(ts[1]);
        return hour*60+min;
    }
}