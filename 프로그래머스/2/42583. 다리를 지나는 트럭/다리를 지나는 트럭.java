import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int[] exitTimes = new int[truck_weights.length];
        Queue<Integer> q = new ArrayDeque<>();
        int time = 1;
        q.offer(0);
        exitTimes[0] = bridge_length + time;
        weight -= truck_weights[0];

        int idx = 1;
        time++;
        
        while (!q.isEmpty()) {
            if (time >= exitTimes[q.peek()]) {
                int pt = q.poll();
                weight += truck_weights[pt];
            }

            if (bridge_length > q.size() && idx < truck_weights.length && weight >= truck_weights[idx]) {
                q.offer(idx);
                weight -= truck_weights[idx];
                exitTimes[idx] = bridge_length + time;
                idx++;
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