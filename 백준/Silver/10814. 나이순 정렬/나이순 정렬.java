import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<Integer, ArrayList<String>> map = new TreeMap<>();

        int N = Integer.parseInt(reader.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int age = Integer.parseInt(tokenizer.nextToken());
            String name = tokenizer.nextToken();

            ArrayList<String> bucket = map.getOrDefault(age, new ArrayList<>());
            bucket.add(name);
            map.put(age, bucket);
        }

        StringBuilder sb = new StringBuilder();
        for (Integer age : map.keySet()) {
            for (String name : map.get(age)) {
                sb.append(age).append(' ').append(name).append('\n');
            }
        }
        System.out.print(sb);
    }
}