import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<int[]> bridge = new ArrayDeque<>(); // 0: 탈출 시간 1: 무게
        int time = 0, load = 0;

        for (int truck : truck_weights) {
            time++;

            while (bridge.size() == bridge_length || load + truck > weight) {
                int[] front = bridge.poll();
                time = Math.max(time, front[0]);
                load -= front[1];
            }

            bridge.offer(new int[]{time + bridge_length, truck});
            load += truck;
        }
        return time + bridge_length;
    }
}