import java.io.*;
import java.util.*;


public class Main {
    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int[][] board;
    static boolean[][] visited;

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        N = read();
        M = read();

        board = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = read();
            }
        }


        int count = 1; //덩어리 수
        int year = 0; //걸리는 시간
        while (count > 0) {
            count = 0;
            year++;
            visited = new boolean[N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board[i][j] > 0 && !visited[i][j]) { //빙산이면
                        if (++count >= 2) {
                            System.out.println(year - 1);
                            return;
                        }
                        bfs(i, j);
                    }
                }
            }
        }
        System.out.println(0);
    }

    public static void bfs(int x, int y) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            x = current.x;
            y = current.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) { //범위 밖
                    continue;
                }
                if (visited[nx][ny]) { //이미 방문
                    continue;
                }
                //얼음이 녹아서 바다가 된건 고려할 필요가 없음 방문 처리에서 걸러짐
                if (board[nx][ny] <= 0) { //바다면 얼음 녹이기
                    board[x][y] -= 1;
                    continue;
                }

                queue.offer(new Node(nx, ny));
                visited[nx][ny] = true;
            }
        }
    }

    public static int read() throws IOException {
        int d = System.in.read();
        boolean isMinus = false;

        if (d == '-') {
            isMinus = true;
            d = System.in.read();
        }
        int o = d - '0';

        while ((d = System.in.read()) > ' ') {
            o = (o << 3) + (o << 1) + (d - '0');
        }
        return isMinus ? -o : o;

    }
}