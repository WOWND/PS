import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(tokenizer.nextToken()));
        }

        int num = Integer.parseInt(reader.readLine());
        int answer = 0;

        for (Integer i : set) {
            if (set.contains(num - i)) {
                if (i == num - i) {
                    //answer++;
                } else {
                    answer++;
                }
            }
        }
        System.out.println(answer / 2);
    }
}