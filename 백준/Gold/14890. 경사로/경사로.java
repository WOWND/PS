import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] board;
    static int N, L;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        L = Integer.parseInt(tokenizer.nextToken());

        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = reader.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = str.charAt(j * 2) - '0';
            }
        }

        int answer = 0;

        //가로

        A: for (int i = 0; i < N; i++) {
            boolean[] isUsed = new boolean[N];

            for (int j = 0; j < N - 1; j++) {
                int cur = board[i][j];
                int next = board[i][j + 1];

                if (Math.abs(cur - next) > 1) { //불가능
                    continue A;
                }

                if (cur < next) {// 오르막
                    if (!checkH(i, j + 1, isUsed, -1)) {
                        continue A;
                    }
                } else if (cur > next) { //내리막
                    if (!checkH(i, j, isUsed, 1)) {
                        continue A;
                    }
                    j += L - 1;
                }
            }
            answer++;
        }

        //세로
        A: for (int i = 0; i < N; i++) {
            boolean[] isUsed = new boolean[N];

            for (int j = 0; j < N - 1; j++) {
                int cur = board[j][i];
                int next = board[j + 1][i];

                if (Math.abs(cur - next) > 1) { //불가능
                    continue A;
                }

                if (cur < next) {// 오르막
                    if (!checkV(i, j + 1, isUsed, -1)) {
                        continue A;
                    }
                } else if (cur > next) { //내리막
                    if (!checkV(i, j, isUsed, 1)) {
                        continue A;
                    }
                    j += L - 1;
                }
            }
            answer++;
        }


        System.out.println(answer);

    }

    static boolean checkH(int j,int start, boolean[] isUsed, int dir) { //1: 내리막 앞에 설치 , -1: 오르막 뒤에 설치
        for (int i = 1; i <= L; i++) {
            int next = start + i * dir;
            if (next<0 || next >= N || board[j][next] + 1 != board[j][start] || isUsed[next]) {
                return false;
            }
        }

        for (int i = 1; i <= L; i++) {
            isUsed[start + i * dir] = true;
        }
        return true;
    }

    static boolean checkV(int j,int start, boolean[] isUsed, int dir) { //1: 내리막 앞에 설치 , -1: 오르막 뒤에 설치
        for (int i = 1; i <= L; i++) {
            int next = start + i * dir;
            if (next<0 || next >= N || board[next][j] + 1 != board[start][j] || isUsed[next]) {
                return false;
            }
        }

        for (int i = 1; i <= L; i++) {
            isUsed[start + i * dir] = true;
        }
        return true;
    }
}
