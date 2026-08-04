import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        Map<Character, Character> pairMap = new HashMap<>();
        pairMap.put('}', '{');
        pairMap.put(')', '(');
        pairMap.put(']', '[');

        Stack<Character> stack = new Stack<>();
        A: for (int i = 0; i < s.length(); i++) { //시작 위치
            stack.clear();
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt((i + j) % s.length());

                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty() || stack.peek() != pairMap.get(c)) {
                        continue A;
                    } else {
                        stack.pop();
                    }
                }
            }
            
            if (stack.isEmpty()) {
                answer++;
            }
        }
        
        return answer;
    }
}