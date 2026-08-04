import java.util.Stack;

class Solution {
    static class Stocks {
        int time;
        int price;

        public Stocks(int time, int price) {
            this.time = time;
            this.price = price;
        }
    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            answer[i] = prices.length - i - 1;
        }

        Stack<Stocks> stack = new Stack<>();
        for (int time = 0; time < prices.length; time++) {
            Stocks curr = new Stocks(time, prices[time]);

            while (!stack.isEmpty() && stack.peek().price > curr.price) {
                Stocks prev = stack.pop();
                answer[prev.time] = time - prev.time;
            }
            stack.push(curr);

        }
        return answer;
    }
}