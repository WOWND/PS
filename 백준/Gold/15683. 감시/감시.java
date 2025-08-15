import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static int r, c, count;
    static char[][] board;
    static boolean[][][] visited;
    static int min = Integer.MAX_VALUE;

    static int[] dx = {1, 0, -1, 0, 1, 0, -1, 0}; //하,좌, 상, 우
    static int[] dy = {0, -1, 0, 1, 0, -1, 0, 1};

    static Node[] CCTV = new Node[8];
    static class Node {
        int x, y;
        char type;

        public Node(int x, int y, char type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        r = Integer.parseInt(tokenizer.nextToken());
        c = Integer.parseInt(tokenizer.nextToken());

        board = new char[r][c];
        for (int i = 0; i < r; i++) {
            String str = reader.readLine();
            for (int j = 0; j < c; j++) {
                char c = str.charAt(j * 2);
                if (c != '0' && c != '6') {
                    CCTV[count++] = new Node(i, j, c);
                }
                board[i][j] = c;
            }
        }
        visited = new boolean[count][][];

        func(0);
        System.out.println(min);
    }

    private static void func(int cur) {
        if (cur == count) {
            int result = 0;

            for (int i = 0; i < r; i++) {
                A: for (int j = 0; j < c; j++) {
                    if (board[i][j] == '0') {
                        for (int k = 0; k < count; k++) {
                            if (visited[k][i][j]) { //방문한적 있으면 사각지대 x
                                continue A;
                            }
                        }
                        result++;
                    }
                }
            }
            min = Math.min(min, result);
            return;
        }

        Node node = CCTV[cur];
        if (node.type == '5') {
            visited[cur] = new boolean[r][c];
            visit(cur, node, dx[0], dy[0]);
            visit(cur, node, dx[1], dy[1]);
            visit(cur, node, dx[2], dy[2]);
            visit(cur, node, dx[3], dy[3]);
            func(cur + 1);
        } else if (node.type == '4') {
            for (int i = 0; i < 4; i++) {
                visited[cur] = new boolean[r][c];
                visit(cur, node, dx[i], dy[i]);
                visit(cur, node, dx[i + 1], dy[i + 1]);
                visit(cur, node, dx[i + 2], dy[i + 2]);
                func(cur + 1);
            }
        }else if (node.type == '3') {
            for (int i = 0; i < 4; i++) {
                visited[cur] = new boolean[r][c];
                visit(cur, node, dx[i], dy[i]);
                visit(cur, node, dx[i + 1], dy[i + 1]);
                func(cur + 1);
            }
        }else if (node.type == '2') {
            for (int i = 0; i < 2; i++) {
                visited[cur] = new boolean[r][c];
                visit(cur, node, dx[i], dy[i]);
                visit(cur, node, dx[i + 2], dy[i + 2]);
                func(cur + 1);
            }
        }else{
            for (int i = 0; i < 4; i++) {
                visited[cur] = new boolean[r][c];
                visit(cur, node, dx[i], dy[i]);
                func(cur + 1);
            }
        }
    }

    private static void visit(int cur, Node node, int dx, int dy) {
        int nx = node.x + dx;
        int ny = node.y + dy;

        while (nx >= 0 && nx < r && ny >= 0 && ny < c && board[nx][ny] != '6') {
            visited[cur][nx][ny] = true;
            nx += dx;
            ny += dy;
        }
    }
}