import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //범위가 -1_000_000 ~ 1_000_000 & 중복이 없음 -> 계수 정렬 (Counting Sort) 사용

        boolean[] count = new boolean[2_000_001]; // 0 -> -1_000_000

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());
            count[temp + 1_000_000] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2_000_001; i++) {
            if (count[i]) {
                sb.append(i - 1_000_000).append("\n");
            }
        }

        System.out.println(sb);
    }
}
