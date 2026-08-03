import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] challengers = new int[N+2];
        for(int i: stages){
            challengers[i]++;
        }

        int cnt = stages.length;
        Map<Integer, Double> fp = new LinkedHashMap<>();
        for(int i = 1; i <= N; i++) {
            int challenger = challengers[i];
            if (cnt == 0) {
                fp.put(i, 0.);
            } else {
                fp.put(i, (double) challenger / cnt);
            } 
            cnt -= challenger;
        }

        return fp.entrySet().stream().sorted((e1,e2) -> Double.compare(e2.getValue(),e1.getValue()))
                .mapToInt(e -> e.getKey())
                .toArray();
    }
}