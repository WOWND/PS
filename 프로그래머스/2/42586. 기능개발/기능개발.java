import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < progresses.length; i++) {
            q.offer((int) Math.ceil((100. - progresses[i]) / speeds[i]));
        }

        List<Integer> answer = new ArrayList<>();
        while (!q.isEmpty()) {
            int d = q.poll();
            int cnt = 1;
            
            while (!q.isEmpty() && q.peek() <= d) {
                q.poll();
                cnt++;
            }
            answer.add(cnt);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}