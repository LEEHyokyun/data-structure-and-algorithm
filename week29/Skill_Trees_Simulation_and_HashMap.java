package week29;

import java.util.HashMap;
import java.util.Map;

public class Skill_Trees_Simulation_and_HashMap {
    public int solution(String skill, String[] skill_trees) {

        int count = 0 ;
        for(String skill_tree : skill_trees){
            if(isPossible(skill, skill_tree)) count++;
        }

        return count;
    }

    static boolean isPossible(String skill, String skill_tree){

        boolean[] learned = new boolean[skill.length()];
        Map<String, Integer> map = new HashMap<>();

        //System.out.println("현재 스킬 트리 : " + skill_tree);

        for(int i = 0 ; i < skill.length() ; i++){
            int count = map.getOrDefault(skill.charAt(i), 0);

            //System.out.println("skill 문자 : " + skill.charAt(i) + " count 입력 : " + count);

            map.put(String.valueOf(skill.charAt(i)), count);
        }

        for(int i = 0 ; i < skill_tree.length() ; i++){
            char c = skill_tree.charAt(i);
            int idx = skill.indexOf(c);


            //System.out.println("현재 스킬트리에서 확인해야할 문자 : " + c);
            //System.out.println("그 문자가 스킬 문자열에 위치하는 인덱스 : " + idx);

            //스킬에 존재하지 않으면 그냥 넘어가도 됨
            if(idx == -1) continue;

            //스킬에 존재하면 배웠는지 확인 필요
            for(int j = 0 ; j < idx ; j++){
                char mustLearned = skill.charAt(j);
                int isLearned = map.getOrDefault(String.valueOf(mustLearned), 0);

                //System.out.println("mustLearned : " + mustLearned);
                //System.out.println("isLearned : " + isLearned);

                if(isLearned == 0) return false;
            }


            map.put(String.valueOf(c), map.getOrDefault(String.valueOf(c), 0) + 1);
            //System.out.println("현재 스킬트리의 문자 " + c + "를 배웠습니다.");
            //System.out.println("현재 스킬트리 카운팅 : " + map.getOrDefault(String.valueOf(c), 0));
        }

        return true;
    }
}
