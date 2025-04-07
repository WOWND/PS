import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        String[] names = new String[N+1]; //이름이 담겨있고 인덱스를 번호로 갖는 배열
        HashMap<String, Integer> map = new HashMap<>(); //키:이름, 값:번호

        for (int i = 1; i <= N; i++) {
            String name = reader.readLine();
            names[i] = name;
            map.put(name, i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String find = reader.readLine();
            if (find.charAt(0) <= '9') { //번호면
                sb.append(names[Integer.parseInt(find)]).append('\n');
            }else{ //이름이면
                sb.append(map.get(find)).append('\n');
            }
        }

        System.out.print(sb);
    }
}