import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        String str = reader.readLine();

        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');

        A: for (int i = 0; i < N; i++) {
            Deque<Character> stack = new ArrayDeque<>();
            for (int j = 0; j < str.length(); j++) {
                char target = str.charAt(j);

                if (target == '(') {
                    stack.push(target);
                } else {
                    if (stack.isEmpty()) { //비어있으면
                        System.out.println("NO");
                        str = reader.readLine();
                        continue A;
                    }

                    char peek = stack.peek();
                    if ('(' != peek) { //짝이 안맞으면
                        System.out.println("NO");
                        str = reader.readLine();
                        continue A;
                    }
                    stack.pop();
                }
            }
            //다 돌았으면 다 비웠나 체크
            if (stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            str = reader.readLine();
        }
    }
}