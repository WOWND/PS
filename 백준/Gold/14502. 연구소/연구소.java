import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static char[][] board;
    static int N,M, answer,safeArea;
    static ArrayList<Point> viruses = new ArrayList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            String str = reader.readLine();
            for (int j = 0; j < M; j++) {
                char c = str.charAt(j * 2);
                board[i][j] = c;
                if (c == '2') {
                    viruses.add(new Point(i, j));
                } else if (c == '0') {
                    safeArea++;
                }
            }
        }
        reader.close();
        
        comb(0,0);

        System.out.println(answer - 3);
    }

    public static void comb(int cnt,int idx) {
        if (cnt == 3) {
            bfs();
            return;
        }

        for (int i = idx; i < N * M; i++) {
            if(board[i / M][i % M] == '0'){
                board[i / M][i % M] = '1';
                comb(cnt + 1, i + 1);
                board[i / M][i % M] = '0';
            }
        }
    }

    public static void bfs() {
        ArrayDeque<Point> queue = new ArrayDeque<>(viruses);
        boolean[][] visited = new boolean[N][M];
        int move = 0;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            int x = cur.x;
            int y = cur.y;

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {//범위밖
                    continue;
                }

                if (board[nx][ny] != '0' || visited[nx][ny]) {//방문했거나 벽
                    continue;
                }
                visited[nx][ny] = true;
                queue.add(new Point(nx, ny));
                move++;
            }
        }

        answer = Math.max(answer, safeArea - move);
    }
}
