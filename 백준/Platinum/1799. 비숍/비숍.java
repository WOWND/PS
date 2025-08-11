import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static boolean[][] diagonal = new boolean[2][20];
    static ArrayList<int[]>[][] board;


    static int[] answer = new int[2];


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(reader.readLine());

        board = new ArrayList[2][2 * N];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2 * N; j++) {
                board[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < N; i++) {
            String str = reader.readLine();
            for (int j = 0; j < N; j++) {
                if (str.charAt(j * 2) == '1') {
                    int color = (i + j) % 2;
                    int index = i - j + N;
                    board[color][index].add(new int[]{i, j});
                }
            }
        }

        solution(0, 0, 0);
        solution(0, 0, 1);
        System.out.println(answer[0] + answer[1]);
    }

    public static void solution(int idx, int count, int color) {
        if (idx == 2 * N) {
            answer[color] = Math.max(answer[color], count);
            return;
        }

        for (int[] point : board[color][idx]) {
            int x = point[0];
            int y = point[1];

            if (diagonal[color][x + y]) {
                continue;
            }
            diagonal[color][x + y] = true;
            solution(idx + 1, count + 1, color);
            diagonal[color][x + y] = false;
        }
        solution(idx + 1, count, color);
    }
}