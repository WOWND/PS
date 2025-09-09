import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] nums;
    static int[] ops = new int[4];
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());

        nums = new int[N];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(tokenizer.nextToken());
        }

        ops = new int[4];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < 4; i++) {
            ops[i] = Integer.parseInt(tokenizer.nextToken());
        }

        comb(new int[N - 1], 0);
        System.out.println(max);
        System.out.println(min);
    }

    static void comb(int[] comb, int cnt) {
        if (cnt == N - 1) {
            calc(comb);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (ops[i] == 0) continue;
            ops[i]--;
            comb[cnt] = i;
            comb(comb, cnt + 1);
            ops[i]++;
        }
    }

    static void calc(int[] comb) {
        int cur = nums[0];

        for (int i = 0; i < N - 1; i++) {
            int c = comb[i];
            if (c == 0) {
                cur += nums[i + 1];
            } else if (c == 1) {
                cur -= nums[i + 1];
            } else if (c == 2) {
                cur *= nums[i + 1];
            } else {
                cur /= nums[i + 1];
            }
        }
        max = Math.max(max, cur);
        min = Math.min(min, cur);
    }

}
