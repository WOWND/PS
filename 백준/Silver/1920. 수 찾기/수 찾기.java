import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashSet<Integer> set = new HashSet<>();
        int N = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer1 = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(tokenizer1.nextToken()));
        }

        int M = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer2 = new StringTokenizer(reader.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(set.contains(Integer.parseInt(tokenizer2.nextToken())) ? "1\n" : "0\n");
        }
        System.out.print(sb);
    }
}