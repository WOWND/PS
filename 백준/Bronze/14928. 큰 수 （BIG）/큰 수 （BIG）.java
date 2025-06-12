import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String num = reader.readLine();

        long answer = 0;
        for (int i = 0; i < num.length(); i++) {
            answer = (answer * 10 + num.charAt(i) - '0') % 20000303;
        }
        System.out.println(answer);
    }
}