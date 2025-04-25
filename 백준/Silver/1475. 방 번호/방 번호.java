import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());

        int[] counts = new int[10];
        while (num > 0) {
            counts[num % 10]++;
            num /= 10;
        }

        int temp = (int) Math.round( (counts[6] + counts[9]) / 2.0);

        counts[6] = temp;
        counts[9] = temp;

        int max = 0;
        for (int i = 0; i < 10; i++) {
            max = Math.max(counts[i], max);
        }

        System.out.println(max);
    }
}