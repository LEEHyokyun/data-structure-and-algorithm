package week17;

public class numbersDFS {
    static int answer = 0;

    public int solution(int[] numbers, int target) {

        //완전탐색, 2개 ~ 20개..
        dfs(numbers, target, 0, 0);

        return answer;
    }

    static void dfs(int[] numbers, int target, int depth, int result){

//         if(start == numbers.length && result == target){
//             answer++;
//             return;
//         }

//         if(start == numbers.length){
//             return;
//         }

//         for(int i = start ; i < numbers.length ; i++){
//             int cur = numbers[i];

//             //다음 단계로 넘어가려면 start + 1이 아닌 i + 1
//             //i = 0일때 start = 1이지만
//             dfs(numbers, target, i + 1, result + cur);
//             dfs(numbers, target, i + 1, result - cur);
//         }

        if(depth == numbers.length){
            if(result == target){
                answer++;
            }

            return;
        }

        dfs(numbers, target, depth + 1, result + numbers[depth]);
        dfs(numbers, target, depth + 1, result - numbers[depth]);
    }
}
