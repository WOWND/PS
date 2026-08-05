import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> c1 = new ArrayDeque<>();
        for (String s : cards1) {
            c1.offer(s);
        }
        Queue<String> c2 = new ArrayDeque<>();
        for (String s : cards2) {
            c2.offer(s);
        }

        for (String s : goal) {
            if (!c1.isEmpty() && c1.peek().equals(s)) {
                c1.poll();
            } else if (!c2.isEmpty() && c2.peek().equals(s)) {
                c2.poll();
            } else {
                return "No";
            }
        }
        
        
        return "Yes";
    }
}