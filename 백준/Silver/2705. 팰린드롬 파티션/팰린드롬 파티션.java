import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] dp = new int[1001];

        int T = Integer.parseInt(reader.readLine());

        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < 1001; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i - 1] + dp[i / 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(reader.readLine());
            System.out.println(dp[N]);
        }
    }
}