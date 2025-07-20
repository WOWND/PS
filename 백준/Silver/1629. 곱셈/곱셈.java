import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int A = Integer.parseInt(tokenizer.nextToken());
        int B = Integer.parseInt(tokenizer.nextToken());
        int C = Integer.parseInt(tokenizer.nextToken());

        System.out.println(pow(A, B, C));
    }

    public static long pow(int A, int B, int C) {
        if (B == 1) return A % C;

        long val = pow(A, B / 2, C);
        val = val * val % C;

        if (B % 2 == 0) return val;
        return val * A % C;
    }
}