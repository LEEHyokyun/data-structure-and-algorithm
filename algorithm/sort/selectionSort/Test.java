package algorithm.sort.selectionSort;

import java.util.Arrays;

public class Test {
    public static void main(String[] args){
        SelectionSort ss = new SelectionSort();

        int[] arr = {3,5,4,2,1};

        ss.selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
