import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int[] entryTimes = new int[truck_weights.length];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        entryTimes[0] = 1;
        weight -= truck_weights[0];
        int next = 1;

        int time = 0;
        while (!q.isEmpty()) {
            time++;

            int tn = q.peek();
            if (time - entryTimes[tn] >= bridge_length) {
                q.poll();
                weight += truck_weights[tn];
            }

            if (bridge_length > q.size() && next < truck_weights.length && weight >= truck_weights[next]) {
                q.offer(next);
                entryTimes[next] = time;
                weight -= truck_weights[next];
                next++;
            }
        }
        return time;
    }
}