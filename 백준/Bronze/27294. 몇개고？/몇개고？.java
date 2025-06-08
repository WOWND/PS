import java.io.IOException;

public class Main {
    public static void main(String[] args)throws IOException {
        int T = read();
        int S = read();

        if (S == 1 || T <= 11 || T > 16) { //술 or no 점심
            System.out.println(280);
        } else {
            System.out.println(320);
        }
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
