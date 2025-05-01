import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        int MX = 10_000;
        int[] deque = new int[MX * 2 + 1];
        int head = MX;
        int tail = MX;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String s = reader.readLine();
            StringTokenizer tokenizer = new StringTokenizer(s);

            switch (tokenizer.nextToken()) {
                case "push_front" :
                    deque[--head] = Integer.parseInt(tokenizer.nextToken());
                    break;
                case "push_back":
                    deque[tail++] = Integer.parseInt(tokenizer.nextToken());
                    break;
                case "pop_front":
                    if (tail - head > 0) {
                        sb.append(deque[head++]).append('\n');
                    } else {
                        sb.append("-1\n");
                    }
                    break;
                case "pop_back":
                    if (tail - head > 0) {
                        sb.append(deque[--tail]).append('\n');
                    } else {
                        sb.append("-1\n");
                    }
                    break;
                case "size":
                    sb.append(tail - head).append('\n');
                    break;
                case "empty":
                    sb.append(tail - head == 0 ? "1\n" : "0\n");
                    break;
                case "front":
                    if (tail - head > 0) {
                        sb.append(deque[head]).append('\n');
                    } else {
                        sb.append("-1\n");
                    }
                    break;
                case "back":
                    if (tail - head > 0) {
                        sb.append(deque[tail - 1]).append('\n');
                    } else {
                        sb.append("-1\n");
                    }
                    break;
            }
        }
        reader.close();
        System.out.print(sb);
    }
}