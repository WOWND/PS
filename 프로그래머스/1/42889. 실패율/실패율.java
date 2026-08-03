import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    static class StageInfo implements Comparable<StageInfo>{
        double value;
        int stageNum;

        public StageInfo(double value, int stageNum){
            this.value = value;
            this.stageNum = stageNum;
        }

        public int compareTo(StageInfo o){
            int cv = Double.compare(o.value, this.value);
            if(cv !=0){
                return cv;
            }
            return Integer.compare(this.stageNum, o.stageNum);
        }
    }

    public int[] solution(int N, int[] stages) {
        List<StageInfo> siList = new ArrayList<>();

        int[] fails = new int[N+2];
        for(int i: stages){
            fails[i]++;
        }

        int cnt = fails[N+1];
        for(int i = N; i > 0; i--){
            int stageCnt = fails[i];
            cnt += stageCnt;
            double fp = cnt == 0 ? 0 : (double) stageCnt / cnt;
            StageInfo stageInfo = new StageInfo(fp, i);
            siList.add(stageInfo);
        }

        return siList.stream().sorted().mapToInt(s->s.stageNum).toArray();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = solution.solution(3, new int[]{1});
        System.out.println(Arrays.toString(a));
    }
}