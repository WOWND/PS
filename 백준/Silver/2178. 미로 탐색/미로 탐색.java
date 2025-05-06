import java.io.*;
import java.util.*;


public class Main {
    static char[][] board;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String str = reader.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        System.out.println(bfs(0, 0));
    }

    static class Node {
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    public static int bfs(int x, int y) {
        Queue<Node> queue = new ArrayDeque<>();

        queue.offer(new Node(x, y, 1));
        board[x][y] = '0'; //방문처리

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            x = current.x;
            y = current.y;

            //인접노드 방문하기
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length) {
                    continue;
                }
                if (board[nx][ny] == '0') {
                    continue;
                }

                if (nx == board.length - 1 && ny == board[0].length - 1) {
                    return current.cost + 1;
                }
                queue.offer(new Node(nx, ny, current.cost + 1)); //추가
                board[nx][ny] = '0'; //방문처리
            }
        }

        return 0;
    }
}