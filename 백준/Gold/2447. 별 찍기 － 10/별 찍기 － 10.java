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

        answer = new char[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(answer[i], ' ');
        }


        func(0, 0, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(answer[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }


    public static void func(int r, int c, int N) {
        if (N == 1) {
            answer[r][c] = '*';
            return;
        }

        int n = N / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != 1 || j != 1) {
                    func(r + n * i, c + n * j, N / 3);
                }
            }
        }
    }
}