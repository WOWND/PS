import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());

        int[] units = new int[N];
        for (int i = 0; i < N; i++) {
            units[i] = Integer.parseInt(reader.readLine());
        }

        int answer = 0;
        int index = N - 1;
        while (K > 0) {
            answer += K / units[index];
            K %= units[index--];
        }

        System.out.println(answer);
    }
}