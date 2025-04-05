import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }

        Arrays.sort(arr);

        int trimCount = (int) Math.round(n * 0.15);
        double answer = 0;
        for (int i = trimCount; i < n - trimCount; i++) {
            answer += arr[i];
        }
        System.out.println( Math.round(answer / (n - 2 * trimCount)));
    }
}