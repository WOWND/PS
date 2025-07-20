import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        System.out.println((int)Math.pow(2, n) - 1);
        move(1, 3, n);
        System.out.print(sb);
    }

    public static void move(int a, int b, int n) {
        if (n == 1) {
            sb.append(a).append(' ').append(b).append('\n');
            return;
        }

        move(a, 6 - a - b, n - 1);
        sb.append(a).append(' ').append(b).append('\n');
        move(6 - a - b, b, n - 1);
    }
}