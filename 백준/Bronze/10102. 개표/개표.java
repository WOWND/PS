import java.io.IOException;

public class Main {
    public static void main(String[] args)throws IOException {
        int N = read();
        int countA = 0;
        int countB = 0;
        for (int i = 0; i < N; i++) {
            if (System.in.read() == 'A') {
                countA++;
            } else {
                countB++;
            }
        }
        System.out.println(countA == countB ? "Tie" : countA > countB ? "A" : "B");
    }
    public static int read() throws IOException {
        int d = System.in.read();
        boolean isMinus = false;

        if (d == '-') {
            isMinus = true;
            d = System.in.read();
        }
        int o = d - '0';

        while ((d = System.in.read()) > ' ') {
            o = (o << 3) + (o << 1) + (d - '0');
        }
        return isMinus ? -o : o;

    }
}
