import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] board1;
    static int N, M, wallCnt, min = 1000;
    static ArrayList<Point> viruses = new ArrayList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        board1 = new int[N][N];


        for (int i = 0; i < N; i++) {
            String str = reader.readLine();
            for (int j = 0; j < N; j++) {
                int c = str.charAt(j * 2) - '0';
                if (c == 2) {
                    viruses.add(new Point(i, j));
                } else if (c == 1) {
                    board1[i][j] = c;
                    wallCnt++;
                }
            }
        }
        reader.close();

        comb(new int[M], 0, 0);
        System.out.println(min == 1000 ? -1 : min);
    }

    public static void comb(int[] virus, int cnt, int idx) {
        if (cnt == M) {
            bfs(virus);
            return;
        }

        for (int i = idx; i < viruses.size(); i++) {
            virus[cnt] = i;
            comb(virus, cnt + 1, i + 1);
        }

    }

    public static void bfs(int[] virus) {
        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], -1);
        }

        int moveCnt = 0;
        ArrayDeque<Point> queue = new ArrayDeque<>();
        for (int i = 0; i < M; i++) {
            Point point = viruses.get(virus[i]);
            queue.add(point);
            dist[point.x][point.y] = 0;
            moveCnt++;
        }

        int maxTime = 0;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            int x = cur.x;
            int y = cur.y;
            maxTime = Math.max(maxTime, dist[x][y]);

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {//범위밖
                    continue;
                }

                if (board1[nx][ny] != 0 || dist[nx][ny] >= 0) {//벽or방문
                    continue;
                }
                dist[nx][ny] = dist[x][y] + 1;
                queue.add(new Point(nx, ny));
                moveCnt++;
            }
        }

        if (wallCnt + moveCnt != N * N) {
            return;
        }

        min = Math.min(min, maxTime);
    }
}
