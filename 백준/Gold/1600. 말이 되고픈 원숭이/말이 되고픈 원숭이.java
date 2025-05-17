import org.w3c.dom.Node;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;


public class Main {
    static class Node{
        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    static int[] dx = {1, -1, 0, 0, 2, 2, -2, -2, 1, 1, -1, -1};
    static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1, 2, -2, 2, -2};

    public static void main(String[] args) throws IOException {
        int K = read();
        int W = read();
        int H = read();

        int[][] board = new int[H][W];
        int[][][] dist = new int[K+1][H][W];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                board[i][j] = read();
            }
        }

        for (int i = 0; i <= K; i++) {
            for (int j = 0; j < H; j++) {
                Arrays.fill(dist[i][j], -1);
            }
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(0, 0, K));
        dist[K][0][0] = 0;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int x = current.x;
            int y = current.y;
            int count = current.count;

            if (x == H - 1 && y == W - 1) {
                System.out.println(dist[count][x][y]);
                return;
            }

            for (int i = 0; i < 12; i++) {
                int nCount = count;
                if (i >= 4) { //말 움직임 불가능
                    if (count == 0) {
                        break;
                    }
                    nCount--;
                }

                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= H || ny >= W) { //범위 밖
                    continue;
                }
                if (board[nx][ny] == 1) { //장애물이면
                    continue;
                }
                if (dist[nCount][nx][ny] >= 0) { //이미 방문
                    continue;
                }
                queue.offer(new Node(nx, ny, nCount));
                dist[nCount][nx][ny] = dist[count][x][y] + 1;
            }
        }

        System.out.println(-1);
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


