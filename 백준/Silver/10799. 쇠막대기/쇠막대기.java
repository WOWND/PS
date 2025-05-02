import java.io.*;
import java.util.*;


public class Main {
    static Stack<Character> stack = new Stack<>();
    static int answer = 0;
    static char prev;

    public static void main(String[] args) throws IOException {
        //출력용
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();

        for (int i = 0; i < str.length(); i++) {
            solution(str.charAt(i));
        }

        System.out.println(answer);
    }

    public static void solution(char c) {
        if (stack.isEmpty()) {
            stack.push(c);
        } else {
            if (c == '(') { //막대 시작이면 일단 추가
                stack.push(c);
            } else {
                if (prev == '(') { //레이저
                    answer += stack.size() - 1;
                } else { //막대 끝
                    answer += 1;
                }
                stack.pop();
            }
        }

        prev = c;
    }
}
