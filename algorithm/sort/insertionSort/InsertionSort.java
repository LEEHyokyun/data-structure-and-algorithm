package algorithm.sort.insertionSort;

public class InsertionSort {
    public void insertionSort(int[] arr){
        //길이 4 -> 3번 진행
        //첫번째 원소는 정렬되었다고 가정
        for(int i = 1 ; i < arr.length ; i++) {
            //순회구간 = 정렬되어있지 않은 구간
            int insertionData = arr[i];
            int j = 0;
            for(j = i - 1 ; j >= 0 ; j--){
                //비교탐색시작 : 정렬되지않은 구간 -1 부터 배열 첫번째 원소까지.
                if(arr[j] > insertionData){
                    arr[j+1] = arr[j];
                }else{
                    //이미 정렬된 구간을 탐색, 삽입데이터보다 작은 원소를 만났다면 삽입 위치를 찾은 것
                    //삽입위치 j+1
                    break;
                }
            }
            arr[j+1] = insertionData;
        }
    }
}
