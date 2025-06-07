import java.io.IOException;

public class Main {
    public static void main(String[] args)throws IOException {
        int N = read();
        int month = 8 + 7 * (N - 1);
        int year = 2024;
        year += month / 12;
        month %= 12;
        if (month == 0) {
            year -= 1;
            month = 12;
        }
        System.out.print(year + " ");
        System.out.println(month);


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
