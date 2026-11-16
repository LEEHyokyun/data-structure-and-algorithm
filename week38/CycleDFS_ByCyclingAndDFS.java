package week38;

import java.util.ArrayList;
import java.util.List;

public class CycleDFS_ByCyclingAndDFS {
    public int solution(int[] cards) {

        boolean[] visited = new boolean[cards.length];
        List<Integer> groups = new ArrayList<>();
        //String group = "";

        /*
         * - 임의의 상자 하나 선택 후 상자 안 숫자 확인, 그 숫자 순서에 해당하는 박스 오픈
         * - 열어야 하는 상자가 이미 열려있을때까지 반복
         * - 1번 상자 그룹 > 2번 상자 그룹 > ..., 1번 상자 그룹으로 다 열었으면 0점, 그 이후는 x * y
         * - "이 게임에서 얻을 수 있는 최고 점수" = 상자 2개를 선택하는 것은 동일하다.
         */

        /*
         * 사이클 탐색 .. 그래프의 정점 사이클 순회 생성이 명확하다면.
         * - 8 4 7 1 8
         * - 6 5 2 6
         * - 3 3
         * = 4 * 3 * 1
         */

        for(int i = 0 ; i < cards.length ; i++){

            int currentIndex = i;

            //System.out.println("현재 반복문 시작 인덱스 : " + currentIndex);

            if(visited[i]) continue;

            makeGroups(cards, visited, currentIndex, 0, groups);

        }

        groups.sort((a,b) -> b-a);

        //System.out.println(groups.size());
        //System.out.println(groups.get(0));
        //System.out.println(groups.get(1));

        if(groups.size() < 2) return 0;
        else return groups.get(0) * groups.get(1);
    }

    static void makeGroups(int[] cards, boolean[] visited, int currentIndex, int count, List<Integer> groups){

        //복잡하게 갈 필요없이 visited 사용
        if(visited[currentIndex]) {
            //System.out.println("visited[currentIndex]는 이미 방문한 노드이므로 재귀를 종료합니다." + currentIndex);
            //System.out.println("count : " + count);
            groups.add(count);
            return;
        }

        visited[currentIndex] = true;
        //System.out.println("다음 인덱스 : " +(cards[currentIndex] - 1));
        //System.out.println("현재 count : " + count);
        makeGroups(cards, visited, cards[currentIndex] - 1, count + 1, groups);

    }
}
