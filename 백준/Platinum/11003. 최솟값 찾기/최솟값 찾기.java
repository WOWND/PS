import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        //출력용
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int L = Integer.parseInt(tokenizer.nextToken());
        Deque<Num> deque = new ArrayDeque<>();

        tokenizer = new StringTokenizer(reader.readLine());

        for (int i = 0; i < N; i++) {
            int current = Integer.parseInt(tokenizer.nextToken());
            if (deque.isEmpty()) {
                deque.offerLast(new Num(current, i));
            } else {
                if (deque.peekFirst().index <= i - L) { //어짜피 첫 값 아니면 쓰거나 삭제되거나라서 반복문 안해도됨
                    deque.pollFirst();
                }

                while (!deque.isEmpty() &&deque.peekLast().value > current) {
                    deque.pollLast();
                }
                deque.offerLast(new Num(current, i));
            }


            sb.append(deque.peekFirst().value).append(' ');
        }
        System.out.print(sb);
    }
//    public static int read() throws IOException {
//        int d = System.in.read();
//        int o = d - '0';
//
//        while ((d = System.in.read()) > ' ') {
//            o = (o << 3) + (o << 1) + (d - '0');
//        }
//
//        return o;
//    }
    public static class Num{
        int value;
        int index;

        public Num(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
