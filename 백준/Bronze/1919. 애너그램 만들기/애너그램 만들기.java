import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[][] str = new int[2][26];

        for (int j = 0; j < 2; j++) {
            for (char c : reader.readLine().toCharArray()) {
                str[j][c - 'a']++;
            }
        }

        int answer = 0;

        for (int j = 0; j < 26; j++) {
            if (str[0][j] != str[1][j]) {
                answer += Math.abs(str[0][j] - str[1][j]);
            }
        }

        System.out.println(answer);
    }
}