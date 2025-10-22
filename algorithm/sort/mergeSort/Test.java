package algorithm.sort.mergeSort;

import java.util.Arrays;

public class Test {
    public static void main(String[] args){
        MergeSort ms = new MergeSort();

        int[] arr = {3,5,2,4,1,7,8,6};

        ms.mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
