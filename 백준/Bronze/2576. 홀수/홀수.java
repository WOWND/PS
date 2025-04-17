import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int min = 100;
        for (int i = 0; i < 7; i++) {
            int num = Integer.parseInt(reader.readLine());
            if (num % 2 == 1) {
                sum += num;
                min = Math.min(min, num);
            }
        }
        System.out.print(sum == 0 ? -1 : sum + "\n" + min);
    }
}