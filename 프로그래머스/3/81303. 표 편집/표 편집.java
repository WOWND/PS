import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        int[] up = new int[n+2];
        int[] down = new int[n+2];
        k++;
        for(int i = 1; i <= n; i++) {
            up[i] = i - 1;
            down[i] = i + 1;
        }
        
        Stack<Integer> stack = new Stack<>();
        for(String s : cmd) {
            String[] parts = s.split(" ");
            
            if(parts.length > 1) {
                int dist = Integer.parseInt(parts[1]);
                
                for(int i = 0; i < dist; i++) {
                    if(parts[0].equals("U")) {
                        k = up[k];
                    } else {
                        k = down[k];
                    }
                }
            } else {
                if(parts[0].equals("C")) {
                    stack.push(k);
                    down[up[k]] = down[k];
                    up[down[k]] = up[k];
                    
                    if(down[k] > n) {
                        k = up[k];
                    }else {
                        k = down[k];
                    }
                } else { //Z
                    int idx = stack.pop();
                    down[up[idx]] = idx;
                    up[down[idx]] = idx;
                }
            }
        }
        
        char[] answer = new char[n];
        Arrays.fill(answer, 'O');
        
        for(int i : stack) {
            answer[i - 1] = 'X';
        }
        
        return new String(answer);
    }
}