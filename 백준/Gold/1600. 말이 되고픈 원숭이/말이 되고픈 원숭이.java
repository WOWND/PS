import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Node{
        public int x;
        public int y;
        public int k;
        public int steps;

        public Node(int x, int y, int k, int steps) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.steps = steps;
        }
    }
    public static int W;
    public static int H;

    public static int[][] normalMovementSet = {
            {1, 0}, {0, 1}, {-1, 0}, {0, -1}  //기본 움직임
    };



    public static int[][] horseMovement = {
            {2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2} //말 움직임
    };

    public static void main(String[] args) throws IOException {
        //점프를 몇번 사용했는지도 체크해줘야함
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        H = Integer.parseInt(tokenizer.nextToken());
        W = Integer.parseInt(tokenizer.nextToken());

        boolean[][][] visited = new boolean[W][H][K + 1];
        for (int i = 0; i < W; i++) {
            String str = reader.readLine();
            for (int j = 0; j < H; j++) {
                if (str.charAt(j * 2) == '1') {
                    for (int k = 0; k <= K; k++) {
                        visited[i][j][k] = true; //장애물은 가지 못하도록 이미 방문한거로 처리해버림
                    }
                }
            }
        }
        System.out.println(bfs(visited,K));
    }


    public static int bfs(boolean[][][] visited,int K) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(0, 0, K, 0));
        for (int i = 0; i <= K; i++) {
            visited[0][0][i] = true;
        }

        ArrayList<Integer> results = new ArrayList<>();

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int x = current.x;
            int y = current.y;
            int k = current.k;
            int steps = current.steps;

            if (x == W - 1 && y == H - 1) {
                results.add(steps);
                continue;
            }

            for (int[] ints : normalMovementSet) { //일반 움직임
                int nx = ints[0] + x;
                int ny = ints[1] + y;

                if (isValid(nx, ny) && !visited[nx][ny][k]) { //범위가 유효하고 방문한 적이 없으면
                    queue.offer(new Node(nx, ny, k, steps + 1));
                    visited[nx][ny][k] = true;
                }
            }

            if (k > 0) { //말 움직임
                for (int[] ints : horseMovement) {
                    int nx = ints[0] + x;
                    int ny = ints[1] + y;

                    if (isValid(nx, ny) && !visited[nx][ny][k - 1]) { //범위가 유효하고 방문한 적이 없으면
                        queue.offer(new Node(nx, ny, k - 1, steps + 1));
                        visited[nx][ny][k - 1] = true;
                    }
                }
            }
        }

        return results.isEmpty() ? -1 : Collections.min(results);
    }

    public static boolean isValid(int x, int y) {
        return x >= 0 && x < W && y >= 0 && y < H;
    }
}