import java.io.*;
import java.util.*;


public class Main {
    static int[] board;

    public static void main(String[] args) throws IOException {
        Queue<Integer> queue = new ArrayDeque<>();

        int N = read();
        int M = read();

        if (N == M) {
            System.out.println(0);
            return;
        }
        board = new int[100_001];
        Arrays.fill(board, -1);


        board[N] = 0;
        if (N + 1 < 100_001) {
            queue.offer(N + 1);
            board[N + 1] = board[N] + 1;
        }
        if (N - 1 >= 0) {
            queue.offer(N - 1);
            board[N - 1] = board[N] + 1;
        }
        if (N * 2 < 100_001) {
            queue.offer(N * 2);
            board[N * 2] = board[N] + 1;
        }



        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == M) {
                System.out.println(board[current]);
                return;
            }

            if (current + 1 < 100_001 && board[current + 1] < 0) {
                queue.offer(current + 1);
                board[current + 1] = board[current] + 1;
            }
            if (current - 1 >= 0 && board[current - 1] < 0) {
                queue.offer(current - 1);
                board[current - 1] = board[current] + 1;
            }
            if (current * 2 < 100_001 && board[current * 2] < 0) {
                queue.offer(current * 2);
                board[current * 2] = board[current] + 1;
            }
        }


        System.out.println(0);

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