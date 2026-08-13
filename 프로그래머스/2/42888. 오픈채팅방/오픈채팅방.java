import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> msg = new HashMap<>();
        msg.put("Enter", "님이 들어왔습니다.");
        msg.put("Leave", "님이 나갔습니다.");

        Map<String, String> map = new HashMap<>();
        for (String s : record) {
            String[] parts = s.split(" ");
            if (parts.length == 3) {
                map.put(parts[1], parts[2]);
            }
        }

        List<String> answer = new ArrayList<>();
        for (String s : record) {
            String[] parts = s.split(" ");
            if (msg.containsKey(parts[0])) {
                answer.add(map.get(parts[1]) + msg.get(parts[0]));
            }
        }

        return answer.toArray(String[]::new);
    }
}