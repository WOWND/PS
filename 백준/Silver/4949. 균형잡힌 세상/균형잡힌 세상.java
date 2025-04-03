import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();

        HashMap<Character, Character> map = new HashMap<>();
        map.put(']', '[');
        map.put(')', '(');

        A: while (!isFinish(str)) {
            Deque<Character> stack = new ArrayDeque<>();
            for (int i = 0; i < str.length(); i++) {
                char target = str.charAt(i);

                if (target == '(' || target == '[') {
                    stack.push(target);
                } else if (target == ')' || target == ']') {
                    if (stack.isEmpty()) { //비어있으면
                        System.out.println("no");
                        str = reader.readLine();
                        continue A;
                    }

                    char peek = stack.peek();
                    if (map.get(target) != peek) { //짝이 안맞으면
                        System.out.println("no");
                        str = reader.readLine();
                        continue A;
                    }

                    stack.pop();
                }
            }
            //다 돌았으면 다 비웠나 체크
            if (stack.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
            str = reader.readLine();
        }
    }

    public static boolean isFinish(String str) {
        return str.length() == 1 && str.charAt(0) == '.';
    }
}