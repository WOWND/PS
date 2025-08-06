import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[] answer = new int[10];
    static boolean[] isUsed = new boolean[10];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        reader.close();

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        func(0);
        System.out.print(sb);
    }

    static void func(int count) {
        if (count == M) {
            for (int i = 0; i < M; i++) {
                sb.append(answer[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!isUsed[i]) {
                answer[count] = i;
                isUsed[i] = true;
                func(count + 1);
                isUsed[i] = false;
            }
        }
    }

}