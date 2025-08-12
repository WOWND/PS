import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int NUM = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        int[] used = new int[NUM * 2 + 1];

        for (int i = 0; i < N; i++) {
            used[Integer.parseInt(reader.readLine()) + NUM]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2 * NUM + 1; i++) {
            for (int j = 0; j < used[i]; j++) {
                sb.append(i - NUM).append('\n');
            }
        }
        System.out.print(sb);
    }
}