import java.io.*;
import java.util.*;


public class Main {
    static class Node{
        public int x;
        public int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int M;
    static int N;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int[][] board;

    public static void main(String[] args) throws IOException {
        M = read();
        N = read();
        int K = read();

        board = new int[M][N]; //0만 방문

        for (int i = 0; i < K; i++) { //직사각형 채우기
            int sy = read();
            int sx = read();
            int ey = read();
            int ex = read();

            for (int j = sx; j < ex; j++) {
                for (int k = sy; k < ey; k++) {
                    board[j][k] = 1;
                }
            }
        }

        int count = 0;
        ArrayList<Integer> answer = new ArrayList<>();

        for (int j = 0; j < M; j++) {
            for (int k = 0; k < N; k++) {
                if (board[j][k] == 0) { //분리되어 나눠진 영역이면
                    count++;
                    answer.add(bfs(j, k));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(count).append('\n');
        answer.sort(null);
        for (Integer i : answer) {
            sb.append(i).append(' ');
        }
        System.out.print(sb);
    }

    public static int bfs(int x, int y) {
        int count = 0;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(x, y));
        board[x][y] = 1;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            count++;
            x = current.x;
            y = current.y;

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if (nx < 0 || ny < 0 || nx >= M || ny >= N) {
                    continue;
                }

                if (board[nx][ny] == 1) {
                    continue;
                }

                queue.offer(new Node(nx, ny));
                board[nx][ny] = 1;
            }
        }
        return count;
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