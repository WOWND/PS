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
    static int N;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        board = new char[N][N];
        for (int i = 0; i < N; i++) {
            board[i] = reader.readLine().toCharArray();
        }

        int count = 0;
        ArrayList<Integer> answer = new ArrayList<>();

        for (int j = 0; j < N; j++) {
            for (int k = 0; k < N; k++) {
                if (board[j][k] == '1') { //아파트면
                    count++;
                    answer.add(bfs(j, k));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(count).append('\n');
        answer.sort(null);
        for (Integer i : answer) {
            sb.append(i).append('\n');
        }
        System.out.print(sb);
    }

    public static int bfs(int x, int y) {
        int count = 0;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(x, y));
        board[x][y] = '0';

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            count++;
            x = current.x;
            y = current.y;

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }

                if (board[nx][ny] == '0') {
                    continue;
                }

                queue.offer(new Node(nx, ny));
                board[nx][ny] = '0';
            }
        }
        return count;
    }
}