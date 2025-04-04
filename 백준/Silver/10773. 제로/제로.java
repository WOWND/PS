import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(reader.readLine());

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < K; i++) {
            int N = Integer.parseInt(reader.readLine());

            if (N == 0) { //0이면 앞에 수를 뺀다
                stack.pop();
            } else {    //0이 아니면 넣는다
                stack.push(N);
            }
        }
        int answer = 0;
        for (Integer i : stack) {
            answer += i;
        }
        System.out.println(answer);

    }
}