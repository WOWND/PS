import java.io.*;
import java.security.Key;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        LinkedList<Integer> list = new LinkedList<>();

        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }
        ListIterator<Integer> cursor = list.listIterator();

        StringBuilder sb = new StringBuilder();
        sb.append('<');
        while (!list.isEmpty()) {
            for (int i = 0; i < K; i++) {
                if (cursor.hasNext()) {
                    cursor.next();
                } else {
                    cursor = list.listIterator();
                    cursor.next();
                }
            }

            if (cursor.hasPrevious()) {
                sb.append(cursor.previous());
                cursor.remove();
            }

            if (!list.isEmpty()) {
                sb.append(", ");
            }
        }

        sb.append('>');
        System.out.print(sb);
    }
}