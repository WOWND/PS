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

    static int[] dx = {2, 2, -2, -2, 1, 1, -1, -1};
    static int[] dy = {1, -1, 1, -1, 2, -2, 2, -2};

    public static void main(String[] args) throws IOException {

        int T = read();

        for (int i = 0; i < T; i++) {
            int I = read();

            int[][] board = new int[I][I];
            Queue<Node> queue = new ArrayDeque<>();

            Node start = new Node(read(), read());
            Node end = new Node(read(), read());

            queue.offer(start);
            board[start.x][start.y] = 1;

            while (!queue.isEmpty()) {
                Node current = queue.poll();
                int x = current.x;
                int y = current.y;
                if (x == end.x && y == end.y) {
                    System.out.println(board[x][y] - 1);
                    break;
                }

                for (int j = 0; j < 8; j++) {
                    int nx = dx[j] + x;
                    int ny = dy[j] + y;

                    if (nx < 0 || ny < 0 || nx >= I || ny >= I) {
                        continue;
                    }

                    if (board[nx][ny] > 0) {
                        continue;
                    }

                    queue.offer(new Node(nx, ny));
                    board[nx][ny] = board[x][y] + 1;
                }
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