import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        System.out.println(solution(N));
    }

    public static int solution(int N) { //bfs 풀이
        boolean[] visited = new boolean[N + 1];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{1, 0}); //초기값
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int value = current[0];
            int steps = current[1];

            if (value == N) {
                return steps;
            }

            int newIndex = value + 1;
            if (newIndex <= N && !visited[newIndex]) {
                queue.offer(new int[]{newIndex, steps + 1});
                visited[newIndex] = true;
            }

            newIndex = value * 2;
            if (newIndex <= N && !visited[newIndex]) {
                queue.offer(new int[]{value * 2, steps + 1});
                visited[newIndex] = true;
            }

            newIndex = value * 3;
            if (newIndex <= N && !visited[newIndex]) {
                queue.offer(new int[]{newIndex, steps + 1});
                visited[newIndex] = true;
            }
        }
        return 0;
    }
}