import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : completion) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        
        for (String s : participant) {
            int cnt = map.getOrDefault(s, 0);
            if (cnt == 0) {
                return s;
            }
            map.put(s, cnt - 1);
        }
        return null;
    }
    
}