import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] numbers = new int[20];
    static int N;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        int S = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());
        reader.close();
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(tokenizer.nextToken());
        }


        func(0, S);
        System.out.println(count);
    }

    static void func(int index, int sum) {
        if (index != 0 && sum == 0) {
            count++;
        }

        for (int i = index; i < N; i++) {
            func(i + 1, sum - numbers[i]);
        }
    }
}