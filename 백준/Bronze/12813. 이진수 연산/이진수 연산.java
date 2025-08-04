import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char[] arr1 = reader.readLine().toCharArray();
        char[] arr2 = reader.readLine().toCharArray();
        reader.close();
        
        StringBuilder sb1 = new StringBuilder(100_000);
        StringBuilder sb2 = new StringBuilder(100_000);
        StringBuilder sb3 = new StringBuilder(100_000);
        StringBuilder sb4 = new StringBuilder(100_000);
        StringBuilder sb5 = new StringBuilder(100_000);

        for (int i = 0; i < 100_000; i++) {
            int a = arr1[i] - '0';
            int b = arr2[i] - '0';
            sb1.append(a & b);
            sb2.append(a | b);
            sb3.append(a ^ b);
            sb4.append(1 - a);
            sb5.append(1 - b);
        }
        System.out.println(sb1);
        System.out.println(sb2);
        System.out.println(sb3);
        System.out.println(sb4);
        System.out.println(sb5);
    }
}