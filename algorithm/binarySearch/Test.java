package algorithm.binarySearch;

public class Test {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};

        BinarySearch bs = new BinarySearch();
        int index = bs.binarySearch(arr, 3, 0, arr.length-1);
        System.out.println(index);
    }
}
