import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        board = new int[N][N];
        answer = new int[3];

        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        func(N, 0, 0);
        for (int i : answer) {
            System.out.println(i);
        }
    }

    public static void func(int N, int r, int c) {
        if (N == 0) {
            return;
        }

        int num = board[r][c];
        boolean flag = false;

        A: for (int i = r; i < r + N; i++) {
            for (int j = c; j < c + N; j++) {
                if (board[i][j] != num) {
                    flag = true;
                    break A;
                }
            }
        }
        if (flag) {
            for (int i = 0; i < N; i += N/3) {
                for (int j = 0; j < N; j += N/3) {
                    func(N / 3, r + i, c + j);
                }
            }
        } else {
            answer[num + 1]++;
        }
    }
}