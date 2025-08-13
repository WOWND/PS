import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());


        int[] answer = new int[n + m];

        int[] a = new int[n];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int[] b = new int[m];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(tokenizer.nextToken());
        }


        int aidx = 0, bidx = 0;
        for (int i = 0; i < n + m; i++) {
            if (bidx == m) answer[i] = a[aidx++];
            else if(aidx == n) answer[i] = b[bidx++];
            else if(a[aidx]<= b[bidx]) answer[i] = a[aidx++];
            else answer[i] = b[bidx++];
        }

        StringBuilder sb = new StringBuilder();
        for (int i : answer) {
            sb.append(i).append(' ');
        }
        System.out.print(sb);
    }
}