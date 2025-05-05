import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;

        StringBuilder sb = new StringBuilder();
        int count = 1;
        while ((str = reader.readLine()).charAt(0) != '-') {
            sb.append(count++).append(". ").append(solution(str.toCharArray())).append('\n');
        }
        System.out.print(sb);
    }

    public static int solution(char[] str) {
        Stack<Character> stack = new Stack<>();

        int answer = 0;

        for (int i = 0; i < str.length; i++) {
            char current = str[i];

            if (current == '{') { //열린 괄호면 그냥 추가
                stack.push(current);
            } else { //닫힌 괄호면
                if (stack.isEmpty()) { //비어있으면
                    answer += 1;
                    stack.push('{');
                    continue;
                }

                stack.pop();
            }
        }

        if (!stack.isEmpty()) {
            answer += stack.size() / 2;
        }

        return answer;
    }
}