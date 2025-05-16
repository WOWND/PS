import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;


public class Main {
    static int[] board;


    public static void main(String[] args) throws IOException {
        int N = read();
        int K = read();
        board = new int[200_001];
        Arrays.fill(board, -1);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(N);
        board[N] = 0;


        while (!queue.isEmpty()) {
            int x = queue.poll();
            if (x == K) {
                System.out.println(board[x]);
                return;
            }

            int[] dx = {x * 2, x - 1, x + 1};
            for (int i = 0; i < 3; i++) {
                int nx = dx[i];

                if (nx < 0 || nx > 200_000) {
                    continue;
                }

                if (board[nx] != -1 && board[nx] <= board[x]) {
                    continue;
                }

                queue.offer(nx);
                board[nx] = board[x];
                if(i !=0) board[nx]++;
            }
        }
    }

    public static int read() throws IOException {
        int d = System.in.read();
        boolean isMinus = false;

        if (d == '-') {
            isMinus = true;
            d = System.in.read();
        }
        int o = d - '0';

        while ((d = System.in.read()) > ' ') {
            o = (o << 3) + (o << 1) + (d - '0');
        }
        return isMinus ? -o : o;

    }
}


