package week26;

import java.util.ArrayList;
import java.util.List;

public class FunctionsDevelopmentBySimulation {
    public int[] solution(int[] progresses, int[] speeds) {

        int len = progresses.length;


        List<Integer> list = new ArrayList<>();

        int prev = getRequiredTimeToComplete(progresses[0], speeds[0]);
        //System.out.println("최초 필요한 소요시각 : " + prev);

        int count = 1;
        for(int i = 1 ; i < len ; i++){
            int cur = getRequiredTimeToComplete(progresses[i], speeds[i]);

            //System.out.println("현재{" + i + "} 필요한 소요시각 : " + cur);

            if(cur <= prev){
                //System.out.println("이전 보다 더 작아서 count++ 작동");
                count++;
            }else {
                //System.out.println("이전 보다 더 크므로 초기화");
                list.add(count);
                prev = cur;
                count = 1;
            }

            if(i == len -1){
                list.add(count);
            }
        }

        int leng = list.size();

        int[] ans = new int[leng];
        for(int i = 0 ; i < list.size() ; i++){
            ans[i] = list.get(i);
        }

        return ans;
    }

    static int getRequiredTimeToComplete(int progress, int speed){
        //System.out.println(Math.ceil(((100 - (double) progress) / (double) speed)));
        return (int) Math.ceil(((100 - (double) progress) / (double) speed));
    }
}
