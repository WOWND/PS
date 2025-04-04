import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        HashMap<Integer, Integer> map = new HashMap<>(); //카드들을 담을 셋
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(tokenizer.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int M = Integer.parseInt(reader.readLine());
        tokenizer = new StringTokenizer(reader.readLine());

        StringBuilder sb = new StringBuilder(); //출력용
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(tokenizer.nextToken());
            sb.append(map.getOrDefault(num, 0)).append(' ');
        }
        System.out.print(sb);
    }
}