import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        int F = read();
        int S = read();
        int G = read();
        int U = read();
        int D = read() * -1;
        int[] dx = {U, D};
        int[] board = new int[F + 1];
        Arrays.fill(board, -1);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(S);
        board[S] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == G) {
                System.out.println(board[current]);
                return;
            }

            for (int i = 0; i < 2; i++) {
                int nx = dx[i] + current;

                if (nx <= 0 || nx > F) {
                    continue;
                }
                if (board[nx] >= 0) {
                    continue;
                }

                queue.offer(nx);
                board[nx] = board[current] + 1;
            }
        }


        System.out.println("use the stairs");
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