import java.io.*;
import java.util.*;


public class Main {

    static class Node{
        public int x;
        public int y;

        public Node(int x,int  y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    static int M;

    static int[][] board;


    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        int T = read();

        for (int i = 0; i < T; i++) { //테스트 케이스
            M = read(); //행
            N = read(); //열
            int K = read(); //배추 수

            board = new int[M][N];

            for (int j = 0; j < K; j++) { //배추 위치 입력
                board[read()][read()] = 1;
            }

            int count = 0;

            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (board[j][k] == 1) { //배추라면
                        bfs(j, k);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }


    }

    static void bfs(int x,int y) {
        Queue<Node> queue = new ArrayDeque<>();

        queue.offer(new Node(x, y));
        board[x][y] = 0;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            x = current.x;
            y = current.y;

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if (nx < 0 || ny < 0 || nx >= M || ny >= N) {
                    continue;
                }

                if (board[nx][ny] == 0) {
                    continue;
                }

                queue.offer(new Node(nx, ny));
                board[nx][ny] = 0;
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