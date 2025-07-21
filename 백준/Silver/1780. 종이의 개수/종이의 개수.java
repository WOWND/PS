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

    public static boolean check(int N, int r, int c) {
        int num = board[r][c];

        for (int i = r; i < r + N; i++) {
            for (int j = c; j < c + N; j++) {
                if (board[i][j] != num) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void func(int N, int r, int c) {
        if (check(N, r, c)) {
            int n = N / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    func(n, r + i * n, c + j * n);
                }
            }
        } else {
            answer[board[r][c] + 1]++;
        }
    }
}