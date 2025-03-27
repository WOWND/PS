import java.util.*;
class Solution {
    public Object[] solution(int[] answers) {
        int[] count = new int[3];
        int length = answers.length;
        
        int[] supo1 = {1,2,3,4,5}; //5
        int[] supo2 = {2,1,2,3,2,4,2,5}; //8
        int[] supo3 = {3,3,1,1,2,2,4,4,5,5}; //10
        
        
        
        for(int i=0;i<length;++i){
            if(supo1[i%5]==answers[i]) count[0]++;
            if(supo2[i%8]==answers[i]) count[1]++;
            if(supo3[i%10]==answers[i]) count[2]++;
        }
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        int max = Integer.MIN_VALUE;
        
        for(int i=0; i<3 ; ++i){
            if(count[i]>max){
                answer.clear();
                answer.add(i+1);
                max = count[i];
            }else if(count[i]==max){
                answer.add(i+1);
            }
        }
        return answer.toArray();
        
        
        
    }
}