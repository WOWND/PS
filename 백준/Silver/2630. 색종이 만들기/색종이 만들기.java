import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] answer = new int[2];

    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        func(0, 0, N);
        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }


    public static void func(int r, int c, int N) {
        if (N == 0) {
            return;
        }

        int half = N / 2;

        if (check(r, c, N)) { //한장이면
            answer[board[r][c]]++;
        } else {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    func(r + i * half, c + j * half, half);
                }
            }
        }
    }

    public static boolean check(int r, int c, int N) {
        int color = board[r][c];
        for (int i = r; i < r + N; i++) {
            for (int j = c; j < c + N; j++) {
                if (board[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}