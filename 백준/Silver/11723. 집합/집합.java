import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(reader.readLine());
        HashSet<Integer> set = new HashSet<>();


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String[] cmd = reader.readLine().split(" ");

            switch (cmd[0]) {
                case "add":
                    set.add(Integer.parseInt(cmd[1]));
                    break;
                case "remove":
                    set.remove(Integer.parseInt(cmd[1]));
                    break;
                case "check":
                    sb.append(set.contains(Integer.parseInt(cmd[1])) ? 1 : 0).append('\n');
                    break;
                case "toggle":
                    int x = Integer.parseInt(cmd[1]);
                    if(set.contains(x)) set.remove(x);
                    else set.add(x);
                    break;
                case "all":
                    for (int j = 1; j <= 20; j++) {
                        set.add(j);
                    }
                    break;
                case "empty":
                    set.clear();
                    break;
            }
        }
        System.out.print(sb);
    }
}