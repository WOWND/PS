import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < progresses.length; i++) {
            q.offer((int) Math.ceil((100.0 - progresses[i]) / speeds[i]));
        }

        while (!q.isEmpty()) {
            int first = q.poll();
            int cnt = 1;

            while (!q.isEmpty() && q.peek() <= first) {
                q.poll();
                cnt++;
            }
            answer.add(cnt);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

}