import org.w3c.dom.Node;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;


public class Main {
    static class Node{
        int x;
        int prev;

        public Node(int x, int prev) {
            this.x = x;
            this.prev = prev;
        }
    }


    public static void main(String[] args) throws IOException {
        int N = read();
        int K = read();

        Node[] dist = new Node[200_001];


        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(N);
        dist[N] = new Node(N, -1);


        while (!queue.isEmpty()) {
            int x = queue.poll();

            if (x == K) {
                break;
            }

            int[] dx = {x * 2, x + 1, x - 1};
            for (int i = 0; i < 3; i++) {
                int nx = dx[i];

                if (nx < 0 || nx >= 200_001) { //범위 밖
                    continue;
                }
                if (dist[nx] != null) { //이미 방문
                    continue;
                }

                queue.offer(nx);
                dist[nx] = new Node(nx, x);
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();
        Node current = dist[K];
        int count = 0;
        while (current.prev != -1) {
            count++;
            answer.add(current.x);
            current = dist[current.prev];
        }
        answer.add(N);

        StringBuilder sb = new StringBuilder();
        sb.append(count).append('\n');
        for (int i = answer.size() - 1; i >= 0; i--) {
            sb.append(answer.get(i)).append(' ');
        }
        System.out.print(sb);
    }

    public static int read() throws IOException {
        int d = System.in.read();
        boolean isMinus = false;

        if (d == '-') {
            isMinus = true;
            d = System.in.read();
        }
        int o = d - '0';

        while ((d = System.in.read()) > ' ') {
            o = (o << 3) + (o << 1) + (d - '0');
        }
        return isMinus ? -o : o;

    }
}


