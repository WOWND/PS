import java.io.*;
import java.util.*;


public class Main {
    static Stack<Character> stack = new Stack<>();


    static HashMap<Character,Character> close;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        close = new HashMap<>();
        close.put(')', '(');
        close.put(']', '[');


        String str = reader.readLine();

        System.out.println(solution(str.toCharArray()));
    }

    public static int solution(char[] str) {
//        if (stack.isEmpty()) {
//            stack.push(c);
//            score *= c == '(' ? 2 : 3;
//            prev = c;
//            return;
//        }
//        if (c == '(' || c=='[') { //열린거
//            if (prev == '(' || prev == '[') { //이전에도 열린거면
//                score *= c == '(' ? 2 : 3;
//            }
//            stack.push(c);
//        } else { //닫는거면
//            if (prev == ')' || prev == ']') {
//            } else {
//                answer += score;
//                score /= prev == '(' ? 2 : 3;
//
//            }
//            stack.pop();
//        }
//
//        prev = c;

        int answer = 0;
        char prev = 0;
        int score = 1;

        for (char current : str) {
            if (stack.isEmpty()) { //스택이 비었으면
                if (close.containsKey(current)) { //닫힌 괄호면 X
                    return 0;
                }
                stack.push(current);
                score *= current == '(' ? 2 : 3;

            } else { //비어있지 않으면
                if (!close.containsKey(current)) { //열린 괄호면 그냥 추가
                    stack.push(current);
                    score *= current == '(' ? 2 : 3;

                } else { //닫힌 괄호면
                    if (stack.peek() == close.get(current)) { //조합이 맞으면
                        stack.pop();
                    } else {
                        return 0;
                    }

                    if (!close.containsKey(prev)) { //최초의 닫힘만 점수 추가
                        answer += score;
                    }
                    score/= current == ')' ? 2 : 3;
                }
            }

            prev = current;
        }
        if (!stack.isEmpty()) {
            return 0;
        }

        return answer;
    }
}


//for (char current : str) {
//        if (stack.isEmpty()) { //스택이 비었으면
//        if (close.containsKey(current)) { //닫힌 괄호면 X
//        return 0;
//        }
//        stack.push(current);
//            } else { //비어있지 않으면
//                    if (!close.containsKey(current)) { //열린 괄호면 그냥 추가
//        stack.push(current);
//                } else { //닫힌 괄호면
//                        if (stack.peek() == close.get(current)) { //조합이 맞으면
//        stack.pop();
//                    } else {
//                            return 0;
//                            }
//                            }
//                            }
//                            }
//                            if (!stack.isEmpty()) {
//        return 0;
//        }
//
//        return 100;