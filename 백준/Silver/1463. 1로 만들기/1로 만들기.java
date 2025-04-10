import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        System.out.println(solution(N));
    }

    public static int solution(int N) { //반복문 풀이
        int[] dp = new int[N + 1];
        Arrays.fill(dp, 100000);
        dp[1] = 0;

        for (int i = 1; i <= N; i++) {
            int next = i + 1;
            if(next<=N) dp[i + 1] = Math.min(dp[i] + 1, dp[next]);

            next = i * 2;
            if(next<= N) dp[i * 2] = Math.min(dp[i] + 1, dp[next]);

            next = i * 3;
            if(next<=N){ dp[i * 3] = Math.min(dp[i] + 1, dp[next]);}
        }
        return dp[N];
    }
}