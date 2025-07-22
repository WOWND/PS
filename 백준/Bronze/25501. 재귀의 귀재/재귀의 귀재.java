import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(reader.readLine());
        for (int i = 0; i < T; i++) {
            count = 0;
            sb.append(isPalindrome(reader.readLine().toCharArray())).append(' ').append(count).append('\n');
        }
        System.out.print(sb);
    }

    public static int recursion(char[] s, int l, int r){
        count++;
        if(l >= r) return 1;
        else if(s[l] != s[r]) return 0;
        else return recursion(s, l+1, r-1);
    }

    public static int isPalindrome(char[] s){
        return recursion(s, 0, s.length - 1);
    }
}