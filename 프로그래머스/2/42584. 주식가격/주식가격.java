import java.util.Stack;

class Solution {

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            answer[i] = prices.length - i - 1;
        }

        Stack<Integer> stack = new Stack<>();
        for (int time = 0; time < prices.length; time++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[time]) {
                Integer prevTime = stack.pop();
                answer[prevTime] = time - prevTime;
            }
            stack.push(time);

        }
        return answer;
    }
}