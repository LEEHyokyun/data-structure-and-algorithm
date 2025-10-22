package algorithm.sort.quickSort;

public class QuickSort {
    public void quickSort(int[] arr, int left, int right) {
        if(left <= right){
            int pivot = divide(arr, left, right);
            quickSort(arr, left, pivot -1);
            quickSort(arr, pivot + 1, right);
        }
    }

    private int divide(int[] arr, int left, int right){
        int pivot = arr[left];
        int leftStartIndex = left + 1;
        int rightStartIndex = right;

        while(leftStartIndex <= rightStartIndex){
            while(leftStartIndex <= right && pivot >= arr[leftStartIndex]){
                leftStartIndex++;
            }

            while(rightStartIndex >= (left + 1) && pivot <= arr[rightStartIndex]){
                rightStartIndex--;
            }

            if(leftStartIndex <= rightStartIndex){
                //피벗에 대한 조건 만족하였다면 서로의 자리를 맞바꾼다.
                swap(arr, leftStartIndex, rightStartIndex);
            }
        }

        swap(arr, left, rightStartIndex);
        return rightStartIndex;
    }

    private void swap(int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
