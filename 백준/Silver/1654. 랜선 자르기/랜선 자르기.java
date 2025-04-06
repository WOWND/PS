import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] arr;
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int K = Integer.parseInt(tokenizer.nextToken());
        N = Integer.parseInt(tokenizer.nextToken());

        arr = new int[K];
        long high = 0;
        long low = 1;
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
            high += arr[i];
        }
        high /= N;

        if (isPossible(high)) {
            System.out.println(high);
            return;
        }

        System.out.println(solution(low, high));
    }

    public static long solution(long low, long high) {

        if (low + 1 == high) {
            return low;
        }


        long mid = (low + high) / 2;
        if (isPossible(mid)) {
            return solution(mid, high);
        } else {
            return solution(low, mid);
        }
    }

    public static boolean isPossible(long size) {
        int count = 0;
        for (int i : arr) {
            count += (int) (i / size);
        }
        return count >= N;
    }
}