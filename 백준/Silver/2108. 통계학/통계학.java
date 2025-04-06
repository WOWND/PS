import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        int[] arr = new int[8001]; //index 0: -4000, 8000: 4000

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(reader.readLine());
            arr[num + 4000]++;
        }

        ArrayList<Integer> mode = new ArrayList<>();
        int maxCount = -1;

        int sum = 0;
        int index = -1;
        int mid = 0;
        int max = -4000;
        int min = 4000;

        for (int i = 0; i < 8001; i++) { //합 구하기
            int count = arr[i]; //들어있는 수
            if (count == 0) {
                continue;
            }

            int realNum = i - 4000;
            sum += count * realNum; //합

            if (maxCount < count) { //새로운 최빈값이라면
                mode.clear();
                mode.add(realNum);
                maxCount = count;
            } else if (maxCount == count) { //최빈값과 크기가 같다면 추가
                mode.add(realNum);
            }

            if (index < N / 2 && index + count >= N / 2) { //중앙값
                mid = realNum;
            }
            index += count;

            if (max < realNum) {
                max = realNum;
            }
            if (min > realNum) {
                min = realNum;
            }
        }
        sum = (int) Math.round((double) sum / N);
        System.out.println(sum);
        System.out.println(mid);
        System.out.println(mode.get(mode.size() == 1 ? 0 : 1));
        System.out.println(max - min);
    }
}