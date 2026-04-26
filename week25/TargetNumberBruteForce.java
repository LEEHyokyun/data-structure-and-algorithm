package week25;

public class TargetNumberBruteForce {
    public int solution(int[] numbers, int target) {

        //brute force
        int answer = dfs(numbers, 0, 0, 0, target);

        return answer;
    }

    static int dfs(int[] numbers, int idx, int depth, int sum, int target){

        if(depth == numbers.length){
            if(sum == target) return 1;
            else return 0;
        }

        int res = 0;
        for(int i = idx ; i < numbers.length ; i++){
            res += dfs(numbers, i + 1, depth + 1, sum + numbers[i], target);
            res += dfs(numbers, i + 1, depth + 1, sum - numbers[i], target);
        }

        return res;
    }
}
