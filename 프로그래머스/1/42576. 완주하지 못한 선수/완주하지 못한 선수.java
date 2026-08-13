import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : completion) {
            map.merge(s, 1, Integer::sum);
        }

        for (String s : participant) {
            if (map.merge(s, -1, Integer::sum) < 0) {
                return s;
            }
        }
        return null;
    }
}