import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        reader.close();

        int side = Integer.parseInt(tokenizer.nextToken());
        int walk = Integer.parseInt(tokenizer.nextToken());

        Node philo = philo(side, walk);
        System.out.println(philo.x + " " + philo.y);

    }

    public static Node philo(int side, int walk) {
        if (side == 2) {
            switch(walk) {
                case 1:
                    return new Node(1, 1);
                case 2:
                    return new Node(1, 2);
                case 3:
                    return new Node(2, 2);
                case 4:
                    return new Node(2, 1);
            }
        }

        int half = side / 2;
        int section = half * half;

        if (walk <= section) { //시계 90도
            Node node = philo(half, walk);
            return new Node(node.y, node.x);
        } else if (walk <= section * 2) {
            Node node = philo(half, walk - section);
            return new Node(node.x, node.y + half);
        } else if (walk <= section * 3) {
            Node node = philo(half, walk - section * 2);
            return new Node(node.x + half, node.y + half);
        } else { //반시계 90도
            Node node = philo(half, walk - section * 3);
            return new Node(2 * half - node.y + 1, half - node.x + 1);
        }
    }

}