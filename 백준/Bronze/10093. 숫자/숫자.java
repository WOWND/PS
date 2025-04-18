import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        long A = Long.parseLong(tokenizer.nextToken());
        long B = Long.parseLong(tokenizer.nextToken());

        if (A > B) {
            long temp = A;
            A = B;
            B = temp;
        }

        StringBuilder sb = new StringBuilder();
        if (A == B) {
            sb.append("0\n");
        } else {
            sb.append(B - A - 1).append('\n');
        }
        for (long i = A + 1; i < B; i++) {
            sb.append(i).append(' ');
        }
        System.out.print(sb);

    }
}