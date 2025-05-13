import java.io.*;
import java.util.*;


public class Main {
    static int N;

    static int[][] board;
    static boolean[][] visited;

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
    public static void main(String[] args) throws IOException {
        N = read();
        board = new int[N][N];

        int max = -1;
        int min = 101;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int num = read();
                max = Math.max(max, num); //최대높이
                min = Math.min(min, num); //최소높이

                board[i][j] = num;
            }
        }

        int answer = 1; //모든 지역이 잠기지 않으면 항상 1임
        for (int i = min; i < max; i++) { //높이마다
            int count = 0;
            visited = new boolean[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (board[j][k] > i && !visited[j][k]) { //물에 잠기지 않고 방문하지 않았으면
                        bfs(j, k, i);
                        count++;
                    }
                }
            }
            answer = Math.max(answer, count);
        }


        System.out.println(answer);
    }

    public static void bfs(int x, int y,int h) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            x = current.x;
            y = current.y;

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) { //범위 밖이면
                    continue;
                }
                if (visited[nx][ny]) { //이미 방문했다면
                    continue;
                }
                if (board[nx][ny] <= h) { //잠겼다면
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