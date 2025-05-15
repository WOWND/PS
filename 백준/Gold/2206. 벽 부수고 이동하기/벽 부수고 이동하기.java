import java.io.*;
import java.util.*;


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


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};


        char[][] board = new char[N][M];
        int[][][] dist = new int[2][N][M];
        Queue<Node> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            board[i] = reader.readLine().toCharArray();
        }

        queue.offer(new Node(0, 0, 1));
        dist[1][0][0] = 1;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int x = current.x;
            int y = current.y;
            int count = current.count;

            if (x == N - 1 && y == M - 1) { //도착지면
                System.out.println(dist[count][x][y]);
                return;
            }

            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) { //범위밖
                    continue;
                }
                if (dist[count][nx][ny] > 0) { //이미 방문
                    continue;
                }
                if (board[nx][ny] == '1') { //벽
                    if (count > 0) { //부술 수 있으면 부수기
                        queue.offer(new Node(nx, ny, 0));
                        dist[0][nx][ny] = dist[1][x][y] + 1;
                    }
                    continue;
                }

                queue.offer(new Node(nx, ny, count));
                dist[count][nx][ny] = dist[count][x][y] + 1;
            }
        }
        System.out.println(-1);
    }
}