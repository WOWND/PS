import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static char[][] board;
    static int X;
    static int Y;
    static int answer = 0;
    static boolean[][] visited;
    static Set<Character> used = new HashSet<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        X = Integer.parseInt(tokenizer.nextToken());
        Y = Integer.parseInt(tokenizer.nextToken());
        board = new char[X][Y];
        visited = new boolean[X][Y];

        for (int i = 0; i < X; i++) {
            String s = br.readLine();
            for (int j = 0; j < Y; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        visited[0][0] = true;
        used.add(board[0][0]);
        solution(0, 0, 1);
        System.out.println(answer);
    }

    public static void solution(int x, int y, int cnt) {
        answer = Math.max(answer, cnt);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= X || ny < 0 || ny >= Y) {
                continue;
            }

            if (visited[nx][ny]) {
                continue;
            }

            if (used.contains(board[nx][ny])) {
                continue;
            }

            visited[nx][ny] = true;
            used.add(board[nx][ny]);
            solution(nx, ny, cnt + 1);
            visited[nx][ny] = false;
            used.remove(board[nx][ny]);
        }
    }
}
