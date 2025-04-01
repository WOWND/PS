import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        arr = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            char[] str = reader.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str[j] == 'W';
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                answer = Math.min(find(i, j), answer);
            }
        }

        System.out.println(answer);
    }

    public static int find(int x, int y) {
        int count = 0;
        boolean TF = arr[x][y];

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {

                if (arr[i][j] != TF) { //올바른 색이 아니면 count 증가
                    count++;
                }
                TF = !TF;
            }
            TF = !TF;
        }
        return Math.min(count, 64 - count);
    }
}