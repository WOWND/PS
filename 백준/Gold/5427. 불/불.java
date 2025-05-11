import java.io.*;
import java.util.*;


public class Main {
    static class Node{
        public int x;
        public int y;
        public char type;

        public Node(int x, int y,char type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());
        A: for (int i = 0; i < T; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int C = Integer.parseInt(tokenizer.nextToken());
            int R = Integer.parseInt(tokenizer.nextToken());

            int[][] board = new int[R][C];
            Queue<Node> queue = new ArrayDeque<>();

            Node start = null;

            for (int j = 0; j < R; j++) {
                String str = reader.readLine();
                for (int k = 0; k < C; k++) {
                    char c = str.charAt(k);
                    if (c == '#') { //벽
                        board[j][k] = 0;
                    } else if (c == '*') { //불
                        queue.offer(new Node(j, k, 'F'));
                        board[j][k] = 0;
                    } else if (c == '.') { //빈공간
                        board[j][k] = -1;
                    } else { //시작 위치
                        start = new Node(j, k, 'P');
                    }
                }
            }

            queue.offer(start);
            board[start.x][start.y] = 0;

            while (!queue.isEmpty()) {
                Node current = queue.poll();
                int x = current.x;
                int y = current.y;

                for (int k = 0; k < 4; k++) {
                    int nx = dx[k] + x;
                    int ny = dy[k] + y;

                    if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                        if (current.type == 'P') {
                            System.out.println(board[x][y] + 1);
                            continue A;
                        }
                        continue;
                    }

                    if (board[nx][ny] >= 0) {
                        continue;
                    }

                    queue.offer(new Node(nx, ny, current.type));
                    board[nx][ny] = board[x][y] + 1;
                }
            }
            System.out.println("IMPOSSIBLE");
        }
    }
}