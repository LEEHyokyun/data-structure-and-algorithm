package algorithm.sort.mergeSort;

import java.util.Arrays;

public class MergeSort {
    public void mergeSort(int[] arr, int left, int right) {
        if(left < right){
            /*
            * 분할진행
            * */
            int mid = (left + right) / 2;

            /*
            * 반반씩 정렬
            * */
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            /*
            * 분할한 두 배열을 하나로 병합
            * */
            merge(arr, left, mid, right);

        }
        /*
        * 분할종료
        * */
    }

    private void merge(int[] arr, int left, int mid, int right){
        int leftAreaIndex = left;      //left == mid -> 정렬종료
        int rightAreaIndex = mid + 1;  //right == right -> 정렬종료
        int tempArrIndex = left;
        int[] tempArr = new int[right + 1];

        while(leftAreaIndex <= mid && rightAreaIndex <= right){
            /*
            * 한쪽 정렬 완료
            * */
            if(arr[leftAreaIndex] <= arr[rightAreaIndex]){
                tempArr[tempArrIndex] = arr[leftAreaIndex++];
            }else{
                tempArr[tempArrIndex] = arr[rightAreaIndex++];
            }
            tempArrIndex++;
        }

        if(leftAreaIndex > mid){
            //오른쪽 정렬필요
            for(int  i = rightAreaIndex ; i <= right ; i++){
                tempArr[tempArrIndex++] = arr[i];
            }
        }else{
            for(int i = leftAreaIndex  ; i <= mid ; i++){
                tempArr[tempArrIndex++] = arr[i];
            }
        }

        for(int i = left; i <= right; i++){
            arr[i] = tempArr[i];
        }

    }
}
