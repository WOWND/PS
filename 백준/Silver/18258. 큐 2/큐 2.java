import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        int[] queue = new int[2_000_001];
        int head = 0;
        int tail = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

            switch (tokenizer.nextToken()) {
                case "push" :
                    queue[tail++] = Integer.parseInt(tokenizer.nextToken());
                    break;
                case "pop":
                    if (head == tail) {
                        sb.append("-1\n");
                    } else {
                        sb.append(queue[head++]).append('\n');
                    }
                    break;
                case "size":
                    sb.append(tail - head).append('\n');
                    break;
                case "empty":
                    sb.append(head == tail ? "1\n" : "0\n");
                    break;
                case "front":
                    if (head == tail) {
                        sb.append("-1\n");
                    } else {
                        sb.append(queue[head]).append('\n');
                    }
                    break;
                case "back":
                    if (head == tail) {
                        sb.append("-1\n");
                    } else {
                        sb.append(queue[tail - 1]).append('\n');
                    }
                    break;
            }
        }

        System.out.print(sb);
    }
}