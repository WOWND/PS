import java.io.*;
import java.util.*;


public class Main {


    static class Node{
        int x;
        int y;
        int z;

        public Node(int x, int y,int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int L = Integer.parseInt(tokenizer.nextToken());
        int R = Integer.parseInt(tokenizer.nextToken());
        int C = Integer.parseInt(tokenizer.nextToken());

        int[] dx = {1, -1, 0, 0, 0, 0};
        int[] dy = {0, 0, 1, -1, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};

        StringBuilder sb = new StringBuilder();
        //s 시작위치
        //.이동가능
        //# 벽 이동불가능
        //e 도착지

        while (!(L == 0 && R == 0 && C == 0)) {
            int[][][] board = new int[L][R][C];
            Queue<Node> queue = new ArrayDeque<>();
            Node dest = null;

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String str = reader.readLine();
                    for (int k = 0; k < C; k++) {
                        char c = str.charAt(k);
                        if (c == 'S') {
                            queue.offer(new Node(i, j, k));
                        } else if (c == '.') { //이동가능
                            board[i][j][k] = -1;
                        } else if (c == 'E') { //도착지
                            dest = new Node(i, j, k);
                            board[i][j][k] = -1;
                        }
                    }
                }
                reader.readLine();
            }

            boolean flag = false;
            while (!queue.isEmpty()) {
                Node current = queue.poll();
                int x = current.x;
                int y = current.y;
                int z = current.z;

                if (x == dest.x && y == dest.y && z == dest.z) { //도착지면
                    sb.append("Escaped in ").append(String.valueOf(board[x][y][z])).append(" minute(s).").append('\n');
                    flag = true;
                    break;
                }

                for (int j = 0; j < 6; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    int nz = z + dz[j];

                    if (nx < 0 || ny < 0 || nz < 0 || nx >= L || ny >= R || nz >= C) { //범위밖
                        continue;
                    }
                    if (board[nx][ny][nz] >= 0) { //방문 or 벽
                        continue;
                    }

                    queue.offer(new Node(nx, ny, nz));
                    board[nx][ny][nz] = board[x][y][z] + 1;
                }
            }

            if (!flag) {
                sb.append("Trapped!").append('\n');
            }
            tokenizer = new StringTokenizer(reader.readLine());
            L = Integer.parseInt(tokenizer.nextToken());
            R = Integer.parseInt(tokenizer.nextToken());
            C = Integer.parseInt(tokenizer.nextToken());
        }
        System.out.print(sb);
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