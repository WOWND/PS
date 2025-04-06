import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        int[] input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(reader.readLine());
        }

        int index = 1;
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int target = input[i];

            while (target >= index) {
                stack.push(index++);
                sb.append("+\n");
            }

            if (stack.peek() != target) {
                System.out.println("NO");
                return;
            }
            stack.pop();
            sb.append("-\n");
        }

        System.out.print(sb);
    }
}