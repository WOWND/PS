import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int a = Integer.parseInt(tokenizer.nextToken());
        int b = Integer.parseInt(tokenizer.nextToken());
        int y = a * b;

        int max = Math.max(a, b);

        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);

        for (int i = 2; i <= max; ++i) {
            if (isPrime[i]) {
                for (int j = i * 2; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int x = 1;

        for (int i = 2; i <= max; i++) {
            if (isPrime[i]) {
                if (a % i == 0 && b % i == 0) {
                    x *= i;
                    a /= i;
                    b /= i;
                    i--;
                }
            }
        }

        System.out.println(x);
        System.out.println(y/x);
    }
}
