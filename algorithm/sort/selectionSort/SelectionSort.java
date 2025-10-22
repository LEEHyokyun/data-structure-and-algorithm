package algorithm.sort.selectionSort;

public class SelectionSort {
    public void selectionSort(int[] arr){
        //길이 4 -> 3번 진행(마지막 원소 1개 남은 단계는 제외)
        for(int i = 0 ; i < arr.length - 1; i++){
            int minValueIndex = i;
            for(int j = i + 1; j < arr.length ; j++){
                if(arr[j] < arr[minValueIndex]){
                    minValueIndex = j;
                }
            }
            int temp = arr[minValueIndex];
            arr[minValueIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
