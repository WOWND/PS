import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, MAX;
    static int[][][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        board = new int[6][N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < N; j++) {
                board[0][i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        backtracking(0);
        System.out.println(MAX);
    }

    private static void backtracking(int cur) {
        if (cur == 5) {
            int localMax = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    localMax = Math.max(localMax, board[5][i][j]);
                }
            }
            MAX = Math.max(MAX, localMax);
            return;
        }

        for (int j = 0; j < 4; j++) { //4방향 선택
            for (int i = 0; i < N; i++) { //복사
                for (int k = 0; k < N; k++) {
                    board[cur + 1][i][k] = board[cur][i][k];
                }
            }
            move(board[cur + 1], j);
            backtracking(cur + 1);
        }
    }

    private static void move(int[][] cur, int dir) {
        shift(cur, dir);

        if (dir == 0) {
            for (int i = 1; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (cur[i][j] == cur[i - 1][j]) {
                        cur[i - 1][j] *= 2;
                        cur[i][j] = 0;
                    }
                }
            }
        } else if (dir == 1) {
            for (int i = 0; i < N; i++) {
                for (int j = 1; j < N; j++) {
                    if (cur[i][j] == cur[i][j - 1]) {
                        cur[i][j - 1] *= 2;
                        cur[i][j] = 0;
                    }
                }
            }
        } else if (dir == 2) {
            for (int i = N - 2; i >= 0; i--) {
                for (int j = 0; j < N; j++) {
                    if (cur[i][j] == cur[i + 1][j]) {
                        cur[i + 1][j] *= 2;
                        cur[i][j] = 0;
                    }
                }
            }
        } else {
            for (int i = 0; i < N; i++) {
                for (int j = N - 2; j >= 0; j--) {
                    if (cur[i][j] == cur[i][j + 1]) {
                        cur[i][j + 1] *= 2;
                        cur[i][j] = 0;
                    }
                }
            }
        }

        shift(cur, dir);
    }

    private static void shift(int[][] cur, int dir) {
        if (dir == 0) {
            for (int i = 1; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (cur[i][j] != 0) {
                        int idx = 1;
                        while (i - idx >= 0 && cur[i - idx][j] == 0) {
                            idx++;
                        }
                        if (idx > 1) {
                            cur[i - idx + 1][j] = cur[i][j];
                            cur[i][j] = 0;
                        }

                    }
                }
            }
        } else if (dir == 1) {
            for (int i = 0; i < N; i++) {
                for (int j = 1; j < N; j++) {
                    if (cur[i][j] != 0) {
                        int idx = 1;
                        while (j - idx >= 0 && cur[i][j-idx] == 0) {
                            idx++;
                        }
                        if (idx > 1) {
                            cur[i][j - idx + 1] = cur[i][j];
                            cur[i][j] = 0;
                        }
                    }
                }
            }
        } else if (dir == 2) {
            for (int i = N - 2; i >= 0; i--) {
                for (int j = 0; j < N; j++) {
                    if (cur[i][j] != 0) {
                        int idx = 1;
                        while (i + idx < N && cur[i + idx][j] == 0) {
                            idx++;
                        }
                        if (idx > 1) {
                            cur[i + idx - 1][j] = cur[i][j];
                            cur[i][j] = 0;
                        }
                    }
                }
            }
        } else {
            for (int i = 0; i < N; i++) {
                for (int j = N - 2; j >= 0; j--) {
                    if (cur[i][j] != 0) {
                        int idx = 1;
                        while (j + idx < N && cur[i][j + idx] == 0) {
                            idx++;
                        }
                        if (idx > 1) {
                            cur[i][j + idx - 1] = cur[i][j];
                            cur[i][j] = 0;
                        }
                    }
                }
            }
        }
    }
}


