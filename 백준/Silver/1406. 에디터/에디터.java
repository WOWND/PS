import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

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

        Node head = new Node('\0');
        Node cursor = head;

        for (char c : reader.readLine().toCharArray()) {
            Node newNode = new Node(c);
            newNode.prev = cursor; //나의 이전을 커서로
            cursor.next = newNode; //커서의 다음을 나로
            cursor = newNode;
        }

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String str = reader.readLine();
            char cmd = str.charAt(0);
            switch (cmd){
                case 'L':
                    if (cursor != head) { //커서가 맨 앞이 아닐때만
                        cursor = cursor.prev;
                    }
                    break;
                case 'D':
                    if (cursor.next != null) {
                        cursor = cursor.next;
                    }
                    break;
                case 'B':
                    if (cursor != head) {
                        cursor.prev.next = cursor.next;
                        if (cursor.next != null) {
                            cursor.next.prev = cursor.prev;
                        }
                        cursor = cursor.prev;
                    }
                    break;
                case 'P':
                    Node newNode = new Node(str.charAt(2));
                    newNode.next = cursor.next;
                    if (cursor.next != null) {
                        cursor.next.prev = newNode;
                    }
                    cursor.next = newNode;
                    newNode.prev = cursor;
                    cursor = newNode;
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (head != null) {
            if (head.c != '\0') {
                sb.append(head.c);
            }
            head = head.next;
        }
        System.out.println(sb);
    }
}