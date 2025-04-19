import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        reader.close();

        int sumA = 0;
        int sumB = 0;

        for (int i = 0; i < N; i++) {
            int time = Integer.parseInt(tokenizer.nextToken());
            sumA += ((time / 30) + 1) * 10;
            sumB += ((time / 60) + 1) * 15;
        }
        System.out.print(sumA == sumB ? "Y M "+sumA : sumA < sumB ? "Y " + sumA : "M " + sumB);
    }
}