import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int NUM = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        boolean[] used = new boolean[NUM * 2 + 1];

        for (int i = 0; i < N; i++) {
            used[Integer.parseInt(reader.readLine()) + NUM] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = NUM * 2; i >= 0; i--) {
            if (used[i]) {
                sb.append(i - NUM).append('\n');
            }
        }
        System.out.print(sb);
    }
}