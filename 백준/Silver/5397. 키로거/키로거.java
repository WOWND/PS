import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            LinkedList<Character> list = new LinkedList<>();
            ListIterator<Character> cursor = list.listIterator();

            String str = reader.readLine();

            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                switch (c) {
                    case '<':
                        if (cursor.hasPrevious()) cursor.previous();
                        break;
                    case '>':
                        if (cursor.hasNext()) cursor.next();
                        break;
                    case '-':
                        if (cursor.hasPrevious()) {
                            cursor.previous();
                            cursor.remove();
                        }
                        break;
                    default:
                        cursor.add(c);
                        break;
                }
            }

            for (char c : list) {
                sb.append(c);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}