import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[] answer = new int[10];
    static ArrayList<Integer> nums = new ArrayList<>();
    static HashSet<String> set = new HashSet<>();
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(tokenizer.nextToken());
            if (!nums.contains(num)) {
                nums.add(num);
            }
        }
        nums.sort(null);
        reader.close();

        func(0);
        System.out.print(stringBuilder);
    }

    static void func(int count) {
        if (count == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(answer[i]).append(' ');
            }
            String s = sb.toString();
            if (!set.contains(s)) {
                set.add(s);
                sb.append('\n');
                stringBuilder.append(sb);
            }
            return;
        }


        for (int num : nums) {
            answer[count] = num;
            func(count + 1);
        }
    }
}