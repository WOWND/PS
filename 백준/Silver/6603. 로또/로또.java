import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] numbers;
    static boolean[] isUsed;
    static int[] answer = new int[6];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int k;
        while ((k = Integer.parseInt(tokenizer.nextToken())) != 0) {
            numbers = new int[k];
            isUsed = new boolean[k];

            for (int i = 0; i < k; i++) {
                numbers[i] = Integer.parseInt(tokenizer.nextToken());
            }

            func(0, 0);
            tokenizer = new StringTokenizer(reader.readLine());
            sb.append('\n');
        }
        System.out.print(sb);

    }

    static void func(int index, int count) {
        if (count == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(answer[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        if (numbers.length - index + count < 6) {
            return;
        }

        for (int i = index; i < numbers.length; i++) {
            answer[count] = numbers[i];
            isUsed[i] = true;
            func(i + 1, count + 1);
            isUsed[i] = false;
        }
    }
}