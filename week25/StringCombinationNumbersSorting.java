package week25;

import java.util.Arrays;

public class StringCombinationNumbersSorting {
    public String solution(int[] numbers) {

        String[] nums = new String[numbers.length];
        for(int i = 0 ; i < nums.length ; i++){
            nums[i] = String.valueOf(numbers[i]);
        }

        //Comparator 연산 가능하도록 변경
        Arrays.sort(nums, (a, b) -> (b+a).compareTo(a+b));
        //a+b보다 b+a가 더 커서 음수면 b,a순으로 나와야 하니까 반대
//         Arrays.sort(nums, (a,b) -> {
//             Integer val1 = Integer.parseInt(a+b);
//             Integer val2 = Integer.parseInt(b+a);

//             if(val1 >= val2) return -1; //조합시 크면 그대로
//             else return 1; //그 반대의 경우에는 오름차순

//             /*
//             * = (a+b).compareTo(b+a) -> a+b가 더 크면 ab순, b+a가 더 크면 ba순
//             */

//         });

        //greedy..
        //일의자리숫자가 큰 것부터 택
        //일의자리숫자가 같은게 여러개라면
        //무조건 자릿수 작은것 부터

        StringBuilder answer = new StringBuilder();

        for(String number : nums){
            answer.append(number);
        }

        if(answer.charAt(0) == '0') return "0"; //00 -> 그냥 0 출력

        return answer.toString();
    }
}
