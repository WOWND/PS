import java.util.HashSet;
import java.util.Set;

class Solution {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public int solution(String dirs) {
        char[] charArray = dirs.toCharArray();

        int x = 5;
        int y = 5;

        Set<String> log = new HashSet<>();

        for (char c : dirs.toCharArray()) {
            int dir = 0;
            if (c == 'L') {
                dir = 1;
            } else if (c == 'U') {
                dir = 2;
            } else if (c == 'D') {
                dir = 3;
            }

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || nx > 10 || ny < 0 || ny > 10) {
                continue;
            }

            log.add(String.format("%d%d%d%d", x, y, nx, ny));
            log.add(String.format("%d%d%d%d", nx, ny, x, y));

            x = nx;
            y = ny;
        }
        return log.size() / 2;
    }
}