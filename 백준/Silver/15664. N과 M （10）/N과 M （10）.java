import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[] answer = new int[10];
    static int[] nums;
    static HashSet<String> set = new HashSet<>();
    static boolean[] isUsed = new boolean[10];
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        nums = new int[N];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(tokenizer.nextToken());
        }
        Arrays.sort(nums);
        reader.close();

        func(0,0);
        System.out.print(stringBuilder);
    }

    static void func(int index, int count) {
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


        for (int i = index; i < N; i++) {
            if (!isUsed[i]) {
                answer[count] = nums[i];
                isUsed[i] = true;
                func(i + 1, count + 1);
                isUsed[i] = false;
            }
        }
    }
}