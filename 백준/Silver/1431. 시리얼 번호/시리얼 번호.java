import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static class SerialNumber implements Comparable<SerialNumber>{
        String str;
        int sum = 0;

        public SerialNumber(String str) {
            this.str = str;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c >= '0' && c <= '9') {
                    sum += c - '0';
                }
            }
        }

        @Override
        public int compareTo(SerialNumber o) {
            int cmp = Integer.compare(this.str.length(), o.str.length());
            if(cmp != 0 ) return cmp;
            
            cmp =  Integer.compare(this.sum, o.sum);
            if(cmp != 0) return cmp;
            
            return this.str.compareTo(o.str);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        SerialNumber[] numbers = new SerialNumber[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = new SerialNumber(reader.readLine());
        }
        Arrays.sort(numbers);

        StringBuilder sb = new StringBuilder();
        for (SerialNumber number : numbers) {
            sb.append(number.str).append('\n');
        }
        System.out.print(sb);
    }
}