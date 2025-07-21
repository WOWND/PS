import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        reader.close();

        BigInteger result = BigInteger.ONE.shiftLeft(N).subtract(BigInteger.ONE);
        System.out.println(result);
        if (N <= 20) {
            sb = new StringBuilder();
            func(N, 1, 3);
            System.out.print(sb);
        }
    }

    public static void func(int n, int a, int b) {
        if (n == 1) {
            sb.append(a).append(' ').append(b).append('\n');
            return;
        }

        func(n - 1, a, 6 - a - b);
        sb.append(a).append(' ').append(b).append('\n');
        func(n - 1, 6 - a - b, b);
    }
}