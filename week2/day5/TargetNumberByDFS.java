package week2.day5;

public class TargetNumberByDFS {
    int answer = 0;

    public int solution(int[] numbers, int target) {


        //문제조건이 "끝까지" 마지막 요소까지 시행해야 한다는 점이 있으므로 DFS를 생각해볼 수 있다.
        dfs(numbers, 0, 0, target);
        return answer;
    }

    public void dfs(int[] numbers, int sum, int idx, int target){
        //BFS -> while
        //DFS -> 기저조건
        if(idx == numbers.length){ //dfs로 끝까지 했다고 가정하고
            if(sum == target)
                answer++;
            return;
        }

        dfs(numbers, sum + numbers[idx], idx + 1, target);
        dfs(numbers, sum - numbers[idx], idx + 1, target);
    }
}
