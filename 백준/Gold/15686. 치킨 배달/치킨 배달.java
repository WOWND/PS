import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] board;
    static ArrayList<Point> chickens = new ArrayList<>();
    static int N, M, min = Integer.MAX_VALUE;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = reader.readLine();
            for (int j = 0; j < N; j++) {
                int t = str.charAt(j * 2) - '0';
                board[i][j] = t;
                if (t == 2) { //치킨집
                    chickens.add(new Point(i, j));
                }
            }
        }
        comb(0, 0, chickens.size(),new int[M]);
        System.out.println(min);

    }

    public static void comb(int cnt,int idx,int size,int[] picked) {
        if (cnt == M) {
            min = Math.min(min, bfs(picked));
            return;
        }

        for (int i = idx; i < size; i++) {
            picked[cnt] = i;
            comb(cnt + 1, i + 1, size,picked);
        }
    }

    public static int bfs(int[] picked) {
        int sum = 0;

        Queue<Point> queue = new ArrayDeque<>();
        int[][] visited = new int[N][N];

        for (int i = 0; i < M; i++) {
            Point point = chickens.get(picked[i]);
            queue.add(point);
            visited[point.x][point.y] = 1;
        }

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            int x = cur.x;
            int y = cur.y;


            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }
                if (visited[nx][ny] > 0) {
                    continue;
                }

                queue.add(new Point(nx, ny));
                visited[nx][ny] = visited[x][y] + 1;
                if (board[nx][ny] == 1) {
                    sum += visited[nx][ny] - 1;
                }
            }
        }

        return sum;
    }
}
