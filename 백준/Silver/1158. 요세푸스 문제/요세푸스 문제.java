import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    static int[] dat;
    static int[] pre;
    static int[] nxt;

    static int size = 0;

    static int unused = 1;

    static void init(int size) {
        size++;
        dat = new int[size];
        pre = new int[size];
        nxt = new int[size];
    }

    static void insert(int addr, int val) {
        dat[unused] = val;
        pre[unused] = addr;
        nxt[unused] = nxt[addr];


        if (nxt[addr] != -1) {
            pre[nxt[addr]] = unused;
        }
        nxt[addr] = unused;

        unused++;
        size++;
    }

    static int erase(int addr) {
        if (nxt[addr] == -1) { //끝값이면
            nxt[pre[addr]] = nxt[0]; //첫값으로
        } else {
            nxt[pre[addr]] = nxt[addr];
        }

        if (nxt[addr] != -1) {
            pre[nxt[addr]] = pre[addr];
        }

        size--;
        return dat[addr];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());
        init(N);

        Arrays.fill(dat,-1);
        Arrays.fill(pre,-1);
        Arrays.fill(nxt,-1);

        for (int i = 1; i <= N; i++) {
            dat[i] = i;
            pre[i] = (i == 1) ? N : i - 1;
            nxt[i] = (i == N) ? 1 : i + 1;
        }

        size = N;
        int addr = 1;

        StringBuilder sb = new StringBuilder();
        sb.append('<');
        while (size > 0) {
            for (int i = 1; i < K; i++) {
                addr = nxt[addr];
            }
            sb.append(erase(addr));
            if (size > 0) {
                sb.append(", ");
            }
            addr = nxt[addr];
        }
        sb.append('>');
        System.out.println(sb);
    }
}