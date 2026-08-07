import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> endTimeQ = new ArrayDeque<>();
        for (int i = 0; i < progresses.length; i++) {
            endTimeQ.offer((int) Math.ceil((100. - progresses[i]) / speeds[i]));
        }

        List<Integer> answer = new ArrayList<>();
        while (!endTimeQ.isEmpty()) {
            int curr = endTimeQ.poll();
            int cnt = 1;

            while (!endTimeQ.isEmpty() && endTimeQ.peek() <= curr) {
                endTimeQ.poll();
                cnt++;
            }
            answer.add(cnt);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
}