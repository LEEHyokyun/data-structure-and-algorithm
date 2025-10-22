package algorithm.sort.bubbleSort;

public class BubbleSort {
    public void bubbleSort(int[] arr){
        //길이 4 -> 3번 진행 -> 0 ~ 2
        for(int i = 0 ; i < arr.length - 1; i++){
            for(int j = 0 ; j < arr.length - i -1 ; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
