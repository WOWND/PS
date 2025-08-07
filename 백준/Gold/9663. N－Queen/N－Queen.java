import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[][] board;
    static int N;
    static int answer = 0;

    static boolean[] col = new boolean[15];
    static boolean[] diagonal1 = new boolean[30];
    static boolean[] diagonal2 = new boolean[30];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());

        board = new boolean[N][N];
        func(0);
        System.out.println(answer);
    }

    static void func(int y) {
        if (N == y) {
            answer++;
            return;
        }

        for (int x = 0; x < N; x++) {
            if (col[x] || diagonal1[x + y] || diagonal2[x - y + N]) {
                continue;
            }
            col[x] = diagonal1[x + y] = diagonal2[x - y + N] = true;
            func(y + 1);
            col[x] = diagonal1[x + y] = diagonal2[x - y + N] = false;
        }
    }
}
