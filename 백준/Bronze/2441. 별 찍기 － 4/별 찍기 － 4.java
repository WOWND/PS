import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = T; i > 0; i--) {
            sb.append(" ".repeat(T-i)).append("*".repeat(i)).append('\n');
        }

        System.out.print(sb);
    }
}