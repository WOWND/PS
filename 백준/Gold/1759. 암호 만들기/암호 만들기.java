import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    static char[] arr;
    static int L,C;
    static char[] answer;
    static StringBuilder sb = new StringBuilder();
    static HashSet<Character> set = new HashSet<>();
    static int[] check = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        L = Integer.parseInt(tokenizer.nextToken());
        C = Integer.parseInt(tokenizer.nextToken());

        arr = new char[C];
        answer = new char[L];
        String str = reader.readLine();
        reader.close();
        for (int i = 0; i < C; i++) {
            arr[i] = str.charAt(i * 2);
        }
        Arrays.sort(arr);

        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        func(0, 0);
        System.out.print(sb);
    }

    static void func(int index, int count) {
        if (count == L) {
            if (check[0] < 1 || check[1] < 2) {
                return;
            }
            sb.append(answer);
            sb.append('\n');
            return;
        }

        for (int i = index; i < C; i++) {
            answer[count] = arr[i];
            int idx = set.contains(arr[i]) ? 0 : 1;
            check[idx]++;
            func(i + 1, count + 1);
            check[idx]--;
        }
    }
}
