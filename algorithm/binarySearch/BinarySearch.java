package algorithm.binarySearch;

public class BinarySearch {
    public int binarySearch(int[] arr, int target, int start, int end){
        if(start > end){
            return -1;
        }

        int mid = (start + end) / 2;

        if(arr[mid] == target){
            return mid;
        }else if(arr[mid] > target){
            return binarySearch(arr, target, start, mid + 1);
        }else{
            return binarySearch(arr, target, start, mid - 1);
        }

    }
}
