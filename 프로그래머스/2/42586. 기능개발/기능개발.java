import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < progresses.length; i++) {
            q.offer(i);
        }

        while (!q.isEmpty()) {
            int first = q.peek();
            int cnt = 0;

            for (int i = first; i < progresses.length; i++) {
                progresses[i] += speeds[i];
            }

            while (!q.isEmpty() && progresses[q.peek()] >= 100) {
                System.out.println(Arrays.toString(progresses));
                q.poll();
                cnt++;
            }

            if (cnt > 0) {
                answer.add(cnt);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

}