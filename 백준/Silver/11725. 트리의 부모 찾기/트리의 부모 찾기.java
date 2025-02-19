import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] adjList;
    static int[] result;


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        adjList = new ArrayList[N+1]; //인접 리스트
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }
        result = new int[N + 1];

        for (int i = 1; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());

            adjList[a].add(b);
            adjList[b].add(a);
        }
        result[1] = 1;
        dfs(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(result[i]);
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void dfs(int n){
        for (Integer next : adjList[n]) {
            if(result[next] == 0){
                result[next] = n;
                dfs(next);
            }
        }
    }
}