package algorithm.recursion.arraySum;

public class ArraySum {
    public int arraySum(int[] nums, int index){
        if(index == 0)
            return nums[index];
        return arraySum(nums, index-1) + nums[index - 1];
    }
}
