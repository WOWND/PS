import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {
        int answer = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int min = Integer.parseInt(reader.readLine());
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                min = Math.min(Integer.parseInt(reader.readLine()), min);
            }
            answer += min;
            min = 2001;
        }
        System.out.println(answer - 50);
    }
}