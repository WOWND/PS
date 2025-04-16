import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int a = Integer.parseInt(tokenizer.nextToken());
        int b = Integer.parseInt(tokenizer.nextToken());
        int c = Integer.parseInt(tokenizer.nextToken());
        if (a == b) {
            if (b == c) {
                System.out.println(10_000 + a * 1000);
                return;
            }
            System.out.println(1000 + a * 100);
        } else if (b == c) {
            System.out.println(1000 + b * 100);
        } else if (c == a) {
            System.out.println(1000 + c * 100);
        } else {
            System.out.println(Math.max(a, Math.max(b, c)) * 100);
        }
    }
}