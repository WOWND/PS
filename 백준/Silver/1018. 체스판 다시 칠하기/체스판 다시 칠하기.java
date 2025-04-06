import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        boolean[][] boards = new boolean[N][M]; //화이트: 1, 블랙: 0
        for (int i = 0; i < N; i++) {
            String str = reader.readLine();
            for (int j = 0; j < M; j++) {
                boards[i][j] = str.charAt(j) == 'W';
            }
        }

        int answer = 100000;
        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                answer = Math.min(answer, solution(boards, i, j));
            }
        }
        System.out.println(answer);
    }

    static int solution(boolean[][] boards,int x, int y) {
        boolean color = boards[x][y];
        int count = 0;

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if (boards[i][j] != color) {
                    count++;
                }
                color = !color;
            }
            color = !color;
        }

        return Math.min(count,64-count);
    }
}