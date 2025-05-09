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

    static char[][] board;


    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(reader.readLine());


        boolean[][] visited1 = new boolean[N][N];
        boolean[][] visited2 = new boolean[N][N];
        board = new char[N][N];


        for (int i = 0; i < N; i++) {
            board[i] = reader.readLine().toCharArray();
        }

        int count1 = 0;
        int count2 = 0;
        //적록색약 X
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited1[i][j]) { //첫방문이면
                    bfs(i, j, board[i][j], false, visited1);
                    count1++;
                }
            }
        }

        //적록색약 O
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited2[i][j]) { //첫방문이면
                    bfs(i, j, board[i][j], true, visited2);
                    count2++;
                }
            }
        }

        System.out.println(count1 + " " + count2);
    }

    static void bfs(int x,int y,char color, boolean isBlind, boolean[][] visited) {
        Queue<Node> queue = new ArrayDeque<>();

        queue.offer(new Node(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            x = current.x;
            y = current.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= N || ny >= N || nx < 0 || ny < 0) { //범위밖이라면
                    continue;
                }

                if (visited[nx][ny]) { //이미 방문했다면
                    continue;
                }

                if (isBlind) { //색약
                    if (color != board[nx][ny]) { //색 다르면
                        if (color == 'B') { //파랑이면 무조건 안됨
                            continue;
                        } else {
                            if (board[nx][ny] == 'B') {
                                continue;
                            }
                        }
                    }
                } else { //색약 아님
                    if (color != board[nx][ny]) { //색 다르면
                        continue;
                    }
                }
                queue.offer(new Node(nx, ny));
                visited[nx][ny] = true;
            }
        }
    }
}