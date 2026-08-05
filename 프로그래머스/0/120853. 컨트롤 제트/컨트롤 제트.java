import java.util.*;

class Solution {
    public int solution(String s) {
        String[] parts = s.split(" ");

        int answer = 0;
        int tmp = 0;

        for (String part : parts) {
            if (part.equals("Z")) {
                answer -= tmp;
            } else {
                tmp = Integer.parseInt(part);
                answer += tmp;
            }
        }
        
        return answer;
    }
}