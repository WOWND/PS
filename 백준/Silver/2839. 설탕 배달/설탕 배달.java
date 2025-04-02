import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int max = 1_000_000_000;
        int N = Integer.parseInt(reader.readLine());

        int[] dp = new int[N+1];
        dp[0] = max;
        dp[1] = max;
        dp[2] = max;
        dp[3] = 1;
        if (N >= 4) {
            dp[4] = max;
        }
        if (N >= 5) {
            dp[5] = 1;
        }

        for (int i = 6; i <= N; i++) {
            dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
        }
        System.out.println(dp[N] >= max ? -1 : dp[N]);
    }
}