package algorithm.sort.bubbleSort;

import java.util.Arrays;

public class Test {
    public static void main(String[] args){
        BubbleSort bs = new BubbleSort();

        int[] arr = {3,5,4,2,1};

        bs.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
