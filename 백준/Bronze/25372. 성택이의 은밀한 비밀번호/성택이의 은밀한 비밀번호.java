import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(reader.readLine());

        for (int i = 0; i < N; i++) {
            String str = reader.readLine();
            if (str.length() < 6 || str.length() > 9) {
                sb.append("no").append('\n');
            } else {
                sb.append("yes").append('\n');
            }
        }
        System.out.print(sb);
    }
}