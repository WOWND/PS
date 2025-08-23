import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static char[][] gears = new char[5][];
    static int[] idx = {8000, 8000, 8000, 8000, 8000}; //12 방향 톱니 인덱스

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= 4; i++) {
            gears[i] = reader.readLine().toCharArray();
        }

        int K = Integer.parseInt(reader.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(tokenizer.nextToken());
            int dir = Integer.parseInt(tokenizer.nextToken());

            int[] movement = new int[5];
            movement[start] = dir;

            int tmp = start;
            int tmpDir = dir;

            while (tmp >= 2) { //왼쪽 전파
                if (rotate(tmp, -1)) { //회전 불가능
                    break;
                }

                tmpDir *= -1;
                movement[--tmp] = tmpDir;
            }

            while (start <= 3) {//오른쪽 전파
                if (rotate(start, 1)) {//회전 불가능
                    break;
                }
                dir *= -1;
                movement[++start] = dir;
            }

            for (int j = 1; j <= 4; j++) {
                idx[j] += movement[j] * -1;
            }
        }

        reader.close();

        int answer = 0;
        for (int i = 1; i <= 4; i++) {
            answer += gears[i][idx[i] % 8] == '0' ? 0 : 1 << i - 1;
        }
        System.out.println(answer);

    }

    private static boolean rotate(int start, int target) {
        return gears[start][(idx[start] + target * 2) % 8] == gears[start + target][(idx[start + target] + target * -2) % 8];
    }
}
