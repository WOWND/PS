import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        HashSet<String> pool = new HashSet<>();
        for (int i = 0; i < N; i++) {
            pool.add(reader.readLine());
        }

        ArrayList<String> answer = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String name = reader.readLine();
            if (pool.contains(name)) {
                answer.add(name);
            }
        }

        answer.sort(null);

        StringBuilder sb = new StringBuilder();
        sb.append(answer.size());
        for (String s : answer) {
            sb.append('\n').append(s);
        }
        System.out.print(sb);
    }
}