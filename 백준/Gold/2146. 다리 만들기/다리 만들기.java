import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;


public class Main {
    static class Node{
        int x;
        int y;
        int islandNum;
        int dist;

        public Node(int x, int y,int islandNum,int dist) {
            this.x = x;
            this.y = y;
            this.islandNum = islandNum;
            this.dist = dist;
        }
    }

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int[][] board;

    static int N;

    static int minLength = Integer.MAX_VALUE;

    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        N = read();
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = read() * -1;
            }
        }

        //섬 분류하기
        int islandCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == -1) { //섬이라면
                    islandCount++;
                    countIsland(i, j, islandCount);
                }
            }
        }

        //최단거리 구하기
        for (int i = 1; i <= islandCount; i++) {
            visited = new boolean[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (board[j][k] == i) { //i번째 섬에서 출발
                        getLength(j, k, i);
                    }
                }
            }
        }



        System.out.println(minLength);
    }

    public static void getLength(int x, int y, int islandNum) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(x, y, islandNum, 0));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            x = current.x;
            y = current.y;
            islandNum = current.islandNum;
            int dist = current.dist;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) { //범위 밖
                    continue;
                }

                if (visited[nx][ny]) { //이미 방문
                    continue;
                }

                if (board[nx][ny] == 0) { //바다면
                    if (dist + 1 >= minLength) { //최단거리 가능성 X
                        continue;
                    }
                    queue.offer(new Node(nx, ny, islandNum, dist + 1));
                    visited[nx][ny] = true;
                    continue;
                }else if (board[nx][ny] != islandNum) { //바다가 아니고 다른 섬이면
                    minLength = Math.min(minLength, dist); //최단거리 갱신
                    continue;
                }

                //같은 섬에서 이동
                queue.offer(new Node(nx, ny, islandNum, dist));
                visited[nx][ny] = true;
            }
        }
    }

    public static void countIsland(int x, int y, int islandCount) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(x, y, 0, 0));
        board[x][y] = islandCount;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            x = current.x;
            y = current.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) { //범위 밖
                    continue;
                }

                if (board[nx][ny] != -1) { //이미 방문 or 바다
                    continue;
                }
                queue.offer(new Node(nx, ny, 0, 0));
                board[nx][ny] = islandCount;
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


