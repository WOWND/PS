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
        int cut = (int) Math.round(n * 0.15);

        Arrays.sort(arr);

        double sum = 0;
        for (int i = cut; i < n - cut; i++) {
            sum += arr[i];
        }

        System.out.println(Math.round(sum / (n - cut * 2)));
    }
}
