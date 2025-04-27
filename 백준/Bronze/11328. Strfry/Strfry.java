import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        int[][] str;

        A: for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            str = new int[2][26];
            for (int j = 0; j < 2; j++) {
                for (char c : tokenizer.nextToken().toCharArray()) {
                    str[j][c - 'a']++;
                }
            }

            for (int j = 0; j < 26; j++) {
                if (str[0][j] != str[1][j]) {
                    writer.write("Impossible\n");
                    continue A;
                }
            }
            writer.write("Possible\n");
        }
        reader.close();
        writer.flush();
        writer.close();
    }
}