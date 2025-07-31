import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static char[][] board;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        board = new char[N][N];
        for (int i = 0; i < N; i++) {
            board[i] = reader.readLine().toCharArray();
        }
        reader.close();

        func(0, 0, N);

        System.out.print(sb);
    }

    public static boolean check(int r, int c, int n) {
        char color = board[r][c];
        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                if (color != board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void func(int r, int c, int n) {
        if (n == 0) {
            return;
        }

        int nn = n / 2;
        if (!check(r, c, n)) {
            sb.append('(');
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    func(r + nn * i, c + nn * j, nn);
                }
            }
            sb.append(')');
        } else {
            sb.append(board[r][c]);
        }
    }
}