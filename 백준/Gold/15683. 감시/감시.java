import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static Point[] cctv = new Point[10];
    static int r, c, size;


    static int[] dx = {1, 0, -1, 0, 1, 0, -1, 0}; //하 좌 상 우
    static int[] dy = {0, -1, 0, 1, 0, -1, 0, 1}; //하 좌 상 우

    static char[][] board1 = new char[10][10]; //원본
    static char[][] board2 = new char[10][10];

    static int min = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        r = Integer.parseInt(tokenizer.nextToken());
        c = Integer.parseInt(tokenizer.nextToken());

        for (int i = 0; i < r; i++) {
            String str = reader.readLine();
            for (int j = 0; j < c; j++) {
                int c = str.charAt(2 * j);
                if (c != '0' && c != '6') {
                    cctv[size++] = new Point(i, j);
                }
                board1[i][j] = str.charAt(2 * j);
            }
        }

        // 회전 방향 4개를 4진법을 통해 모든 경우의 수를 나타낼 수 있음 크기는 2^k (CCTV 개수)
        for (int i = 0; i < 1 << 2 * size; i++) {
            for (int j = 0; j < r; j++) { //원상복구
                System.arraycopy(board1[j], 0, board2[j], 0, c);
            }

            int tmp = i;
            for (int j = 0; j < size; j++) {
                int dir = tmp % 4;
                tmp /= 4;

                Point cur = cctv[j];
                int x = cur.x;
                int y = cur.y;

                if (board1[x][y] == '1') {
                    visit(x, y, dir);
                } else if (board1[x][y] == '2') {
                    visit(x, y, dir);
                    visit(x, y, dir + 2);
                }else if (board1[x][y] == '3') {
                    visit(x, y, dir);
                    visit(x, y, dir + 1);
                } else if (board1[x][y] == '4') {
                    visit(x, y, dir);
                    visit(x, y, dir + 1);
                    visit(x, y, dir + 2);
                } else {
                    visit(x, y, dir + 1);
                    visit(x, y, dir + 2);
                    visit(x, y, dir + 3);
                    visit(x, y, dir + 4);
                }
            }

            int cnt = 0;
            for (int k = 0; k < r; k++) {
                for (int l = 0; l < c; l++) {
                    if (board2[k][l] == '0') {
                        cnt++;
                    }
                }
            }
            min = Math.min(min, cnt);
        }
        System.out.println(min);
    }

    private static void visit(int x, int y, int dir) {
        while (x >= 0 && x < r && y >= 0 && y < c && board2[x][y] != '6') {
            board2[x][y] = '7';
            x += dx[dir];
            y += dy[dir];
        }
    }
}