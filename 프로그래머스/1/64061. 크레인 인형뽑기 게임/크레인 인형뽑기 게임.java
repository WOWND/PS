import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        for (int move : moves) {
            move--;

            for (int i = 0; i < board.length; i++) {
                int d = board[i][move];

                if (d != 0) {
                    board[i][move] = 0;
                    if (stack.isEmpty() || stack.peek() != d) {
                        stack.push(d);
                    } else {
                        stack.pop();
                        answer += 2;
                    }
                    break;
                }
            }
        }
        return answer;
    }

}