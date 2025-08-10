import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static class Node{
        int x,y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean[][] isPicked = new boolean[5][5];
    static char[][] board = new char[5][5];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int result = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String str = reader.readLine();
            for (int j = 0; j < 5; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        comb(0, 0, 0);
        System.out.println(result);
    }

    static void comb(int idx, int count, int S) {
        if (count == 7) {
            if (S >= 4) {
                bfs(idx - 1);
            }
            return;
        }

        for (int i = idx; i < 25; i++) {
            isPicked[i / 5][i % 5] = true;
            comb(i + 1, count + 1, S + (board[i / 5][i % 5] == 'S' ? 1 : 0));
            isPicked[i / 5][i % 5] = false;
        }
    }

    static void bfs(int idx) {
        boolean[][] isVisited = new boolean[5][5];
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(idx / 5, idx % 5));
        isVisited[idx / 5][idx % 5] = true;

        int count = 1;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int x = cur.x;
            int y = cur.y;

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) {
                    continue;
                }
                if (isVisited[nx][ny]) {
                    continue;
                }
                if (!isPicked[nx][ny]) {
                    continue;
                }
                q.offer(new Node(nx, ny));
                isVisited[nx][ny] = true;
                count++;
            }
        }
        if (count == 7) result++;
    }
}
