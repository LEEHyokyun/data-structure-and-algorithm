package algorithm.sort.quickSort;

import algorithm.sort.mergeSort.MergeSort;

import java.util.Arrays;

public class Test {
    public static void main(String[] args){
        QuickSort qs = new QuickSort();

        int[] arr = {3,5,2,4,1,7,8,6};

        qs.quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
