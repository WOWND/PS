import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < discount.length; i++) {
            String d = discount[i];
            map.merge(d, 1, Integer::sum);

            if (i >= 9) {
                int flag = 1;
                for (int j = 0; j < want.length; j++) {
                    if (map.getOrDefault(want[j], 0) < number[j]) {
                        flag = 0;
                        break;
                    }
                }
                answer += flag;
                map.merge(discount[i - 9], -1, Integer::sum);
            }
        }

        return answer;
    }
}