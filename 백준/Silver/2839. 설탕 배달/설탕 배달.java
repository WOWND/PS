import java.io.IOException;
import java.util.Scanner;

public class Main {
    static final int MAX = 100_000;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());

        int[] dp = new int[N + 1];

        dp[1] = MAX;
        dp[2] = MAX;
        dp[3] = 1;
        if(N>=4) dp[4] = MAX;
        if(N>=5) dp[5] = 1;

        for (int i = 6; i <= N; i++) {
            dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
        }

        System.out.println(dp[N] >= MAX ? -1 : dp[N]);
    }
}