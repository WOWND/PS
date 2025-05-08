import java.io.*;
import java.util.*;


public class Main {

    static class Node{
        public char type;
        public int x;
        public int y;

        public Node(char type,int x,int  y) {
            this.type = type;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int[][] board;
        Queue<Node> queue = new ArrayDeque<>();

        //불 부터 움직인다.
        //지훈이를 움직인다.
        //지훈이가 범위 밖이면 탈출이다.
        //그 외에는 불가능

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        board = new int[N][M];

        int[] J = new int[2];

        for (int i = 0; i < N; i++) {
            String str = reader.readLine();
            for (int j = 0; j < M; j++) {
                char c = str.charAt(j);

                if (c == '.') {
                    board[i][j] = -1;
                }else {
                    if (c == 'F') {
                        queue.offer(new Node(c, i, j));
                    } else if (c == 'J') {
                        J[0] = i;
                        J[1] = j;
                    }
                    board[i][j] = 0;
                }
            }
        }

        queue.offer(new Node('J', J[0], J[1]));


        while (!queue.isEmpty()) {
            Node current = queue.poll();

            char type = current.type;
            int x = current.x;
            int y = current.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= N || ny >= M || nx < 0 || ny < 0) {
                    if (type == 'J') {
                        System.out.println(board[x][y] + 1);
                        return;
                    }
                    continue;
                }

                if (board[nx][ny] >= 0) {
                    continue;
                }

                queue.offer(new Node(type, nx, ny));
                board[nx][ny] = board[x][y] + 1;
            }
        }

        System.out.println("IMPOSSIBLE");

    }
}