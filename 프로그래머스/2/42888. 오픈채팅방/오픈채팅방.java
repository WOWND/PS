import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String[]> answer = new ArrayList<>();

        Map<String, String> map = new HashMap<>();
        for (String s : record) {
            String[] parts = s.split(" ");
            String cmd = parts[0];
            String id = parts[1];

            if (cmd.equals("Enter")) {
                map.put(id, parts[2]);
                answer.add(new String[]{id, "님이 들어왔습니다."});
            } else if (cmd.equals("Leave")) {
                answer.add(new String[]{id, "님이 나갔습니다."});
            } else {
                map.put(id, parts[2]);
            }
        }

        return answer.stream().map(a -> map.get(a[0]) + a[1]).toArray(String[]::new);
    }
}