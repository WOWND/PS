import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //출력용
        StringBuilder sb = new StringBuilder();

        //테스트케이스
        int T = Integer.parseInt(reader.readLine());
        A:for (int i = 0; i < T; i++) {
            //수행할 명령
            String cmds = reader.readLine();
            int n = Integer.parseInt(reader.readLine());

            Deque<String> deque = new ArrayDeque<>();

            //배열에 들은 수
            String arr = reader.readLine();
            String[] numbers = arr.substring(1, arr.length() - 1).split(",");
            for (int j = 0; j < n; j++) {
                deque.addLast(numbers[j]);
            }

            boolean flag = true; //true: 순행, false: 역행
            for (int j = 0; j < cmds.length(); j++) {
                switch (cmds.charAt(j)) {
                    case 'R':
                        flag = !flag;
                        break;
                    case 'D':
                        if (deque.isEmpty()) {
                            sb.append("error\n");
                            continue A;
                        }
                        if (flag) { //순행이면
                            deque.pollFirst();
                        } else {
                            deque.pollLast();
                        }
                        break;
                }
            }

            //출력
            if (deque.isEmpty()) {
                sb.append("[]\n");
                continue;
            }
            sb.append('[');
            if (flag) {
                sb.append(deque.pollFirst());
                while (!deque.isEmpty()) {
                    sb.append(',').append(deque.pollFirst());

                }
            }else{
                sb.append(deque.pollLast());
                while (!deque.isEmpty()) {
                    sb.append(',').append(deque.pollLast());
                }
            }
            sb.append("]\n");
        }
        System.out.print(sb);
    }
}