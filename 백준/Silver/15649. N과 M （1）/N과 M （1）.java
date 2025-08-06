import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static ArrayList<Integer> list = new ArrayList<>();
    static HashSet<Integer> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        reader.close();

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        func(0);
        System.out.print(sb);
    }

    static void func(int count) {
        if (count == M) {
            for (Integer i : list) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!set.contains(i)) {
                list.add(i);
                set.add(i);
                func(count + 1);
                list.remove(count);
                set.remove(i);
            }
        }
    }

}