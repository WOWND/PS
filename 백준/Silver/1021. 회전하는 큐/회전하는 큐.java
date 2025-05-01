import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        Deque forward = new Deque(10_000);
        Deque backward = new Deque(10_000);

        int N = Integer.parseInt(tokenizer.nextToken());
        for (int i = 1; i <= N; i++) {
            forward.pushBack(i);
            backward.pushBack(i);
        }

        int M = Integer.parseInt(tokenizer.nextToken());
        tokenizer = new StringTokenizer(reader.readLine());

        int answer = 0;

        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(tokenizer.nextToken());
            
            int frontCount = 0;
            while (forward.front() != target) {
                frontCount++;
                forward.pushBack(forward.popFront());
            }
            
            int backCount = 0;
            while (backward.front() != target) {
                backCount++;
                backward.pushFront(backward.popBack());
            }

            answer += Math.min(frontCount, backCount);
            forward.popFront();
            backward.popFront();
        }
        System.out.println(answer);
    }
    static class Deque{
        int[] deque;
        int head;
        int tail;

        public Deque(int MX) {
            deque = new int[MX * 2 + 1];
            head = tail = MX;
        }
        public boolean isEmpty() {
            return tail - head > 0;
        }

        public void pushFront(int val) {
            deque[--head] = val;
        }
        public void pushBack(int val) {
            deque[tail++] = val;
        }

        public int popFront() {
            return deque[head++];
        }
        public int popBack() {
            return deque[--tail];
        }

        public int front() {
            return deque[head];
        }

        public int back() {
            return deque[tail - 1];
        }
    }
}