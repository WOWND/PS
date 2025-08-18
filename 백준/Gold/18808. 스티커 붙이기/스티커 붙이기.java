import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static int N, M, K;

    static boolean[][] board;
    static boolean[][][] stickers;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        K = Integer.parseInt(tokenizer.nextToken());

        board = new boolean[N][M];
        stickers = new boolean[K][][];


        for (int i = 0; i < K; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int r = Integer.parseInt(tokenizer.nextToken());
            int c = Integer.parseInt(tokenizer.nextToken());
            stickers[i] = new boolean[r][c];
            for (int j = 0; j < r; j++) {
                String str = reader.readLine();
                for (int k = 0; k < c; k++) {
                    stickers[i][j][k] = (str.charAt(k * 2) == '1');
                }
            }
        }

        for (int i = 0; i < K; i++) { //스티커 붙이기

            A: for (int j = 0; j < 4; j++) { //4방향 시도
                int r = stickers[i].length;
                int c = stickers[i][0].length;

                for (int k = 0; k + r <= N; k++) {
                    for (int l = 0; l + c <= M; l++) {
                        if (isValid(stickers[i], k, l)) {
                            break A;
                        }
                    }
                }


                rotate(i, stickers[i], r, c);
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j]) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    static boolean isValid(boolean[][] sticker,  int x, int y) {
        int r = sticker.length;
        int c = sticker[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[x + i][y + j] && sticker[i][j]) {
                    return false;
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                board[x + i][y + j] |= sticker[i][j];
            }
        }
        return true;
    }

    static void rotate(int i,boolean[][] sticker, int r, int c) {
        boolean[][] rotated = new boolean[c][r];

        for (int j = 0; j < c; j++) {
            for (int k = 0; k < r; k++) {
                rotated[j][k] = sticker[r - 1 - k][j];
            }
        }
        stickers[i] = rotated;
    }
}