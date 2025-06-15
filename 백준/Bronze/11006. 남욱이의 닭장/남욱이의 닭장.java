import java.io.IOException;

public class Main {
    public static void main(String[] args)throws IOException {
        int T = read();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = read();
            int M = read();

            int a = M * 2 - N;
            sb.append(a).append(' ').append(M - a).append('\n');
        }
        System.out.print(sb);
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