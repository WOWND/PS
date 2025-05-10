import java.io.*;
import java.util.*;


public class Main {

    static class Node{
        public int x;
        public int y;
        public int z;
        public int cost;

        public Node(int x, int y, int z,int cost) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.cost = cost;
        }
    }
    static int N;
    static int M;
    static int H;

    static int[][][] board;


    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        M = read(); //열
        N = read(); //행
        H = read(); //높이

        board = new int[H][N][M];

        Queue<Node> queue = new ArrayDeque<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    int temp = read();
                    if (temp == 1) { //익은 토마토는 큐에 넣기
                        queue.offer(new Node(i, j, k, 0));
                        temp = -1; //방문처리
                    }
                    board[i][j][k] = temp;
                }
            }
        }

        int answer = 0;
        while (!queue.isEmpty()) { //큐가 빌때까지
            Node current = queue.poll();
            int x = current.x;
            int y = current.y;
            int z = current.z;
            int cost = current.cost;
            answer = Math.max(answer, cost);

            for (int i = 0; i < 6; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                int nz = dz[i] + z;

                if (nx < 0 || ny < 0 || nz < 0 || nx >= H || ny >= N || nz >= M) {
                    continue;
                }

                if (board[nx][ny][nz] == -1) {
                    continue;
                }

                queue.offer(new Node(nx, ny, nz, cost + 1));
                board[nx][ny][nz] = -1;
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (board[i][j][k] == 0) { //안익은 토마토 체크
                        System.out.println(-1); //불가능
                        return;
                    }
                }
            }
        }

        System.out.println(answer);
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