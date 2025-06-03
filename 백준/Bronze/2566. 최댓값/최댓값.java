import java.io.IOException;

public class Main {
    public static void main(String[] args)throws IOException {
        int r = 0;
        int c = 0;
        int max = -1;
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                int num = read();
                if (num > max) {
                    max = num;
                    r = i;
                    c = j;
                }
            }
        }
        System.out.println(max);
        System.out.print(r + " " + c);
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
