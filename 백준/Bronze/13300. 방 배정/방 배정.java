import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());

        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int sex = Integer.parseInt(tokenizer.nextToken());
            int grade = Integer.parseInt(tokenizer.nextToken());

            if (sex == 0) {
                map1.merge(grade, 1, Integer::sum);
            }else{
                map2.merge(grade, 1, Integer::sum);
            }
        }

        int answer = 0;
        for (Integer value : map1.values()) {
            answer += (int) Math.ceil((double) value / K);
        }
        for (Integer value : map2.values()) {
            answer += (int) Math.ceil((double) value / K);
        }
        System.out.println(answer);
    }
}