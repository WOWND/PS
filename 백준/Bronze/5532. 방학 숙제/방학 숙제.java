import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(reader.readLine());
        int A = Integer.parseInt(reader.readLine());
        int B = Integer.parseInt(reader.readLine());
        double C = Double.parseDouble(reader.readLine());
        double D = Double.parseDouble(reader.readLine());
        System.out.println(L - (int)Math.max(Math.ceil(A / C), Math.ceil(B / D)));
    }
}