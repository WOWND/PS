import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] board;
    static int N, M, G, R;
    static ArrayList<Point> list = new ArrayList<>();
    static int[] reds = new int[5];
    static int[] greens = new int[5];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int max = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        G = Integer.parseInt(tokenizer.nextToken());
        R = Integer.parseInt(tokenizer.nextToken());

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < M; j++) {
                int n = Integer.parseInt(tokenizer.nextToken());
                if (n == 2) {
                    list.add(new Point(i, j));
                }
                board[i][j] = n;
            }
        }
        comb(0, 0, 0);
        System.out.println(max);
    }

    public static void comb(int red, int green, int idx) {
        if (red == R && green == G) {
            bfs();
            return;
        }

        for (int i = idx; i < list.size(); i++) {
            if (red < R) {
                reds[red] = i;
                comb(red + 1, green, i + 1);
            }
            if (green < G) {
                greens[green] = i;
                comb(red, green + 1, i + 1);
            }
        }
    }

    public static void bfs() {
        Queue<Point> queue = new ArrayDeque<>();
        int[][] visited = new int[N][M];
        int[][] color = new int[N][M];
        int count = 0;

        for (int i = 0; i < R; i++) {
            Point point = list.get(reds[i]);
            queue.offer(point);
            visited[point.x][point.y] = 1;
            color[point.x][point.y] = 1;
        }
        for (int i = 0; i < G; i++) {
            Point point = list.get(greens[i]);
            queue.offer(point);
            visited[point.x][point.y] = 1;
            color[point.x][point.y] = 2;
        }


        while (!queue.isEmpty()) {
            Point current = queue.poll();
            int x = current.x;
            int y = current.y;

            if (visited[x][y] == -1) {//꽃인경우
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                if (board[nx][ny] == 0) { //강이면
                    continue;
                }
                if (visited[nx][ny] == -1) continue; // 이미 꽃이면 완전 무시
                if (visited[nx][ny] > 0) { //방문한적있음
                    if (visited[x][y] + 1 == visited[nx][ny]) { //동시에 도착
                        if (color[x][y] != color[nx][ny] && color[nx][ny] != 0) { //꽃 생성
                            count++;
                            visited[nx][ny] = -1;
                        }
                    }
                    continue;
                }

                queue.offer(new Point(nx, ny));
                visited[nx][ny] = visited[x][y] + 1;
                color[nx][ny] = color[x][y];
            }
        }

        max = Math.max(count, max);
    }
}

