import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int[][] arr1 = init(reader);
        int[][] arr2 = init(reader);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                int sum = 0;
                for (int k = 0; k < arr2.length; k++) {
                    sum += arr1[i][k] * arr2[k][j];
                }
                sb.append(sum).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    public static int[][] init(BufferedReader reader) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
        return arr;
    }
}
