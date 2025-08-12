import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] count = new int[10_001];
        int N = Integer.parseInt(reader.readLine());

        for (int i = 0; i < N; i++) {
            count[Integer.parseInt(reader.readLine())]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 10_001; i++) {
            for (int j = 0; j < count[i]; j++) {
                sb.append(i).append('\n');
            }
        }
        System.out.print(sb);

    }
}