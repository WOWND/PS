import java.util.Stack;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        Stack<Integer> stack = new Stack<>();

        int[] up = new int[n];
        int[] down = new int[n];
        for (int i = 0; i < n; i++) {
            up[i] = i - 1;
            down[i] = i + 1;
        }

        for (String s : cmd) {

            if (s.length() > 2) {
                String[] parts = s.split(" ");
                int dist = Integer.parseInt(parts[1]);

                while (dist > 0) {
                    dist--;
                    if (s.startsWith("U")) {
                        k = up[k];
                    } else {
                        k = down[k];
                    }
                }
            } else if (s.startsWith("C")) {
                stack.push(k);

                if (down[k] != n) {
                    up[down[k]] = up[k];
                }
                if (up[k] != -1) {
                    down[up[k]] = down[k];
                }

                if (down[k] == n) {
                    k = up[k];
                } else {
                    k = down[k];
                }
            } else {
                int z = stack.pop();

                if (up[z] != -1) {
                    down[up[z]] = z;
                }
                if (down[z] != n) {
                    up[down[z]] = z;

                }
            }

        }

        boolean[] removed = new boolean[n];
        while (!stack.isEmpty()) {
            removed[stack.pop()] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (boolean b : removed) {
            sb.append(b ? "X" : "O");
        }
        return sb.toString();
    }
}