import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new ArrayDeque<>();
        int[] exitTimes = new int[truck_weights.length];
        int time = 1;
        q.offer(0);
        exitTimes[0] = time + bridge_length;
        weight -= truck_weights[0];
        int next = 1;
        time++;

        while (!q.isEmpty()) {
            while (!q.isEmpty() && exitTimes[q.peek()] <= time) {
                weight += truck_weights[q.poll()];
            }

            if (next < truck_weights.length && q.size() < bridge_length && truck_weights[next] <= weight) {
                q.offer(next);
                exitTimes[next] = time + bridge_length;
                weight -= truck_weights[next];
                next++;
                time++;
            } else {
                if (!q.isEmpty()) {
                    time = exitTimes[q.peek()];
                }
            }
        }

        return time;

    }
}