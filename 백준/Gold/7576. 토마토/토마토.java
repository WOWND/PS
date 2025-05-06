import java.io.*;
import java.util.*;


public class Main {
    static int[][] board;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N;
    static int M;

    static Queue<Node> queue = new ArrayDeque<>();


    public static void main(String[] args) throws IOException {
        M = read();
        N = read();
        
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = read();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 1) { //익은 토마토 모두 추가
                    queue.offer(new Node(i, j, 0));
                    board[i][j] = -1;
                }
            }
        }

        int answer = bfs();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) { //익지 않은 토마토가 남아있다면
                    answer = -1;
                    break;
                }
            }
        }
        System.out.println(answer);

    }

    public static class Node {
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    public static int bfs() {
        int answer = 0;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            int x = current.x;
            int y = current.y;
            int cost = current.cost;

            answer = Math.max(answer, cost); //최댓값 갱신

            //인접노드 방문하기
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) { //범위 밖
                    continue;
                }
                if (board[nx][ny] == -1) { //빈칸 or 이미 방문
                    continue;
                }

                queue.offer(new Node(nx, ny,cost + 1)); //추가
                board[nx][ny] = -1; //방문처리
            }
        }

        return answer;
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