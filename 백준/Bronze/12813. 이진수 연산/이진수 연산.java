import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[][] nums = new int[2][100_000];

        for (int i = 0; i < 2; i++) {
            String string = reader.readLine();
            for (int j = 0; j < 100_000; j++) {
                nums[i][j] = string.charAt(j) - '0';
            }
        }

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = new StringBuilder();
        StringBuilder sb5 = new StringBuilder();
        for (int i = 0; i < 100_000; i++) {
            sb1.append(nums[0][i] & nums[1][i]);
            sb2.append(nums[0][i] | nums[1][i]);
            sb3.append(nums[0][i] ^ nums[1][i]);
            sb4.append(1 - nums[0][i]);
            sb5.append(1 - nums[1][i]);
        }
        System.out.println(sb1);
        System.out.println(sb2);
        System.out.println(sb3);
        System.out.println(sb4);
        System.out.println(sb5);
    }
}