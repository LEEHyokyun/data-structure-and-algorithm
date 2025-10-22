package algorithm.sort.insertionSort;

import algorithm.sort.selectionSort.SelectionSort;

import java.util.Arrays;

public class Test {
    public static void main(String[] args){
        InsertionSort is = new InsertionSort();

        int[] arr = {3,5,4,2,1};

        is.insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
