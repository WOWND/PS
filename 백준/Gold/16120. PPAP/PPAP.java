import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean result = solution(reader.readLine().toCharArray());
        System.out.println(result ? "PPAP" : "NP");

    }

    public static boolean solution(char[] str) {
        Stack<Character> stack = new Stack<>();

        for (char current : str) {
            if (stack.isEmpty() || current == 'A') { //비어있거나 A이면 그냥 추가
                stack.push(current);
            } else {
                if (stack.peek() == 'A') {
                    if (stack.size() < 3) { //A 앞에는 무조건 PP가 있어야함
                        return false;
                    }
                    stack.pop(); //A

                    if (stack.pop() != 'P' || stack.pop() != 'P') {
                        return false;
                    }
                }
                stack.push(current);
            }
        }

        return stack.size() == 1 && stack.peek() == 'P';
    }
}