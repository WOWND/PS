import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static char[][] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        reader.close();

        answer = new char[N][N * 2 - 1];

        for (int i = 0; i < N; i++) {
            Arrays.fill(answer[i], ' ');
        }


        func(0, N - 1, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N * 2 - 1; j++) {
                sb.append(answer[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }


    public static void func(int r, int c, int n) {
        if (n == 3) {
            answer[r][c] = '*';
            answer[r + 1][c - 1] = '*';
            answer[r + 1][c + 1] = '*';
            for (int i = 0; i < 5; i++) {
                answer[r + 2][c - 2 + i] = '*';
            }
            return;
        }

        int nn = n / 2;
        func(r, c, nn);
        func(r + nn, c - nn, nn);
        func(r + nn, c + nn, nn);

    }
}