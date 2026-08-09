import java.util.Arrays;
import java.util.Stack;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        int[] up = new int[n + 2];
        int[] down = new int[n + 2];
        k++;
        for (int i = 0; i < n+2; i++) {
            up[i] = i - 1;
            down[i] = i + 1;
        }
        Stack<Integer> stack = new Stack<>();

        for (String s : cmd) {
            String[] parts = s.split(" ");
            if (parts.length > 1) {
                int dist = Integer.parseInt(parts[1]);

                while (dist-- > 0) {
                    k = parts[0].equals("D") ? down[k] : up[k];
                }
            } else if (s.equals("C")) {
                down[up[k]] = down[k];
                up[down[k]] = up[k];
                stack.push(k);

                k = down[k] > n ? up[k] : down[k];
            } else { // "Z"
                int z = stack.pop();
                down[up[z]] = z;
                up[down[z]] = z;
            }
        }
        
        char[] answer = new char[n];
        Arrays.fill(answer, 'O');
        for (int i : stack) {
            answer[i - 1] = 'X';
        }
        return new String(answer);
    }
}