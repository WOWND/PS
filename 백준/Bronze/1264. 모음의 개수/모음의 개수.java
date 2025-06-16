import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = reader.readLine();
        while (str.length() != 1 || str.charAt(0) != '#') {
            int count = 0;
            str = str.toLowerCase();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    count++;
                }
            }
            sb.append(count).append('\n');
            str = reader.readLine();
        }
        System.out.print(sb);
    }
}