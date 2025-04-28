import java.io.*;

class Node{
    Node next;
    Node prev;
    char c;

    public Node(char c) {
        this.c = c;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Node start = new Node('\0');
        Node end = new Node('\0');
        Node cursor = start;

        for (char c : reader.readLine().toCharArray()) {
            Node newNode = new Node(c);
            newNode.prev = cursor; //나의 이전을 커서로
            cursor.next = newNode; //커서의 다음을 나로
            cursor = newNode;
        }
        cursor.next = end;


        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String str = reader.readLine();
            char cmd = str.charAt(0);
            switch (cmd){
                case 'L':
                    if (cursor != start) { //커서가 맨 앞이 아닐때만
                        cursor = cursor.prev;
                    }
                    break;
                case 'D':
                    if (cursor.next != end) {
                        cursor = cursor.next;
                    }
                    break;
                case 'B':
                    if (cursor != start) {
                        cursor.prev.next = cursor.next;
                        cursor.next.prev = cursor.prev;
                        cursor = cursor.prev;
                    }
                    break;
                case 'P':
                    Node newNode = new Node(str.charAt(2));
                    newNode.next = cursor.next;
                    newNode.prev = cursor;
                    cursor.next.prev = newNode;
                    cursor.next = newNode;
                    cursor = newNode;
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        start = start.next;
        while (start != end) {
            sb.append(start.c);
            start = start.next;
        }
        System.out.println(sb);
    }
}