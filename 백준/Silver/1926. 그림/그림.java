import java.io.*;
import java.util.*;


public class Main {
    static int[][] board;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        int N = read();
        int M = read();
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = read();
            }
        }

        int count = 0;
        int maxSize = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 1) { //그림의 일부분이면
                    maxSize = Math.max(maxSize, bfs(i, j));
                    count++;
                }
            }
        }

        System.out.println(count);
        System.out.println(maxSize);
    }

    static class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int bfs(int x, int y) {
        int size = 0;
        Queue<Pair> queue = new ArrayDeque<>();

        queue.offer(new Pair(x, y));
        board[x][y] = 0; //방문처리

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            size++;

            x = current.x;
            y = current.y;

            //인접노드 방문하기
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length) {
                    continue;
                }
                if (board[nx][ny] == 0) {
                    continue;
                }
                queue.offer(new Pair(nx, ny)); //추가
                board[nx][ny] = 0; //방문처리
            }
        }

        return size;
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