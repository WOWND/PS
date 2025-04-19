import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[21];
        for (int i = 1; i <= 20; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < 10; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int A = Integer.parseInt(tokenizer.nextToken());
            int B = Integer.parseInt(tokenizer.nextToken());

            for (int j = 0; j <= (B - A) / 2; j++) {
                int temp = arr[A + j];
                arr[A + j] = arr[B - j];
                arr[B - j] = temp;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 20; i++) {
            sb.append(arr[i]).append(' ');
        }
        System.out.print(sb);
    }
}