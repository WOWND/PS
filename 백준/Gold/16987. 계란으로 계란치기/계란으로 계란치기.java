import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class Egg{
        int strength,weight;

        public Egg(int strength, int weight) {
            this.strength = strength;
            this.weight = weight;
        }
    }

    static Egg[] eggs;
    static int N,count,answer;


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());

        eggs = new Egg[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            eggs[i] = new Egg(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));
        }

        solution(0);
        System.out.println(answer);
    }

    public static void solution(int hand) {
        if (hand == N) {
            answer = Math.max(answer, count);
            return;
        }

        if (eggs[hand].strength <= 0) { //손에 든 계란이 깨진 경우
            solution(hand + 1);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (i == hand) { //내가 들고 있는 계란 고름
                continue;
            }

            Egg target = eggs[i];
            if (target.strength <= 0) { //깨진 계란 고름
                continue;
            }

            Egg left = eggs[hand];

            left.strength -= target.weight;
            target.strength -= left.weight;

            int temp = count;
            if (left.strength <= 0) {
                count++;
            }
            if (target.strength <= 0) {
                count++;
            }

            solution(hand + 1);

            left.strength += target.weight;
            target.strength += left.weight;
            count = temp;
        }
        answer = Math.max(answer, count);
    }
}
