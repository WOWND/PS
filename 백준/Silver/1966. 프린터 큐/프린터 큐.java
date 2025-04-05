import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int N = Integer.parseInt(tokenizer.nextToken());
            int M = Integer.parseInt(tokenizer.nextToken());

            Queue<int[]> q = new ArrayDeque<>();
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < N; j++) {
                int priority = Integer.parseInt(tokenizer.nextToken());
                q.add(new int[]{priority, j});
            }

            int count = 0;

            A: while (!q.isEmpty()) {
                int[] now = q.poll();
                int priority = now[0];

                for (int[] next : q) {
                    if (next[0] > priority) { //나보다 우선 순위가 높은게 있다면
                        q.offer(now); //나를 맨 뒤에 넣기
                        continue A;
                    }
                }

                //내가 가장 높으면
                count++;
                if (now[1] == M) { //원하는 문서라면
                    System.out.println(count);
                    break;
                }
            }
        }
    }
}