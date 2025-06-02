import java.io.IOException;

public class Main {
    public static void main(String[] args)throws IOException {
        int total = 0;
        total += read() * 60 * 60;
        total += read() * 60;
        total += read();
        total += read();

        System.out.print(total / 3600 % 24 + " ");
        System.out.print(total / 60 % 60 + " ");
        System.out.print(total % 3600 % 60 + " ");
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
