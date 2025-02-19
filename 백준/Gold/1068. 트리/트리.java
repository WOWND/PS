import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
    static ArrayList<Integer>[] adjList;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        adjList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }

        int root = 0;

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(tokenizer.nextToken());
            if (a == -1) {
                root = i;
                continue;
            }
            adjList[a].add(i); //자식 추가
        }
        int removed = Integer.parseInt(reader.readLine());

        dfs(root,removed);
        System.out.println(answer);
    }

    private static void dfs(int node,int removed) {
        if(node == removed) return;
        if(adjList[node].isEmpty() || adjList[node].size()==1 && adjList[node].get(0) == removed)
            answer++; //자식이 없으면 리프노드
        for (Integer next : adjList[node]) { //자식노드들
            dfs(next,removed);
        }
    }
}
