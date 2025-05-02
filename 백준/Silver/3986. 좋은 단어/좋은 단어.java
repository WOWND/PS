import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        //출력용
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        int count = 0;
        for (int i = 0; i < N; i++) {
            String str = reader.readLine();
            //홀수면  항상 불가능
            if (str.length() % 2 == 1) {
                continue;
            }

            if (isValid(str)) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }
}
