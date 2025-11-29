package week4.day3;

public class BackTracking {
    //백트래킹
    static int count = 0;
    public int solution(int[] number) {
        count = dfs(number, 0, 0, 0);

        return count;
    }

    static int dfs(int[] number, int start, int num, int sum){
        //num = 뽑은 개수..기저조건 : 뽑은개수가 3개일때 합계를 판단해야 한다.
        if(num == 3){
            //sum = 현재 합산
            return (sum == 0) ? 1 : 0;
        }

        int n = number.length;
        int ways =  0;

        //dfs적용 = start
        //최초 시작점을 i
        //그 이후의 조합을 재귀로 찾는다.
        //이 순회가 계속 이루어지므로 조합 시 다른 인덱스를 보장한다.
        for(int i = start ; i < n ; i++){
            //return -> ways.
            //sum = 0일때마다 ways++
            ways += dfs(number, i+1, num+1, sum + number[i]);
        }

        return ways;
    }
}
