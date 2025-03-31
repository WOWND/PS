import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();
        int N = Integer.parseInt(reader.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());

            TreeSet<Integer> bucket = map.getOrDefault(x, new TreeSet<>());
            bucket.add(y);
            map.put(x, bucket);
        }

        StringBuilder sb = new StringBuilder();
        for (Integer x : map.keySet()) {
            for (Integer y  : map.get(x)) {
                sb.append(x).append(' ').append(y).append('\n');
            }
        }

        System.out.print(sb);
    }
}