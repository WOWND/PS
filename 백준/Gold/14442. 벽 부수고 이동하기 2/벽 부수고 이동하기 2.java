import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        int x;
        int y;
        int count;

        public Node(int x, int y,int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());

        char[][] board = new char[N][M];
        int[][][] dist = new int[K + 1][N][M];
//        for (int i = 0; i <= K; i++) {
//            for (int j = 0; j < N; j++) {
//                Arrays.fill(dist[i][j], -1);
//            }
//        }

        for (int i = 0; i < N; i++) {
            board[i] = reader.readLine().toCharArray();
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(0, 0, K));
        dist[K][0][0] = 1;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int x = current.x;
            int y = current.y;
            int count = current.count;

            if (x == N - 1 && y == M - 1) { //도착
                System.out.println(dist[count][x][y]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                int newCount = count;

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                if (board[nx][ny] == '1') { //벽이라면
                    if (count <= 0) { //부수고 이동
                        continue;
                    }
                    newCount--;
                }

                if (dist[newCount][nx][ny] >= 1) { //이미 방문
                    continue;
                }

                queue.offer(new Node(nx, ny, newCount));
                dist[newCount][nx][ny] = dist[count][x][y] + 1;
            }
        }
        System.out.println(-1);
    }
}