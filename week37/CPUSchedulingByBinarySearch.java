package week37;

public class CPUSchedulingByBinarySearch {
    public int solution(int n, int[] cores) {
        /*
         * 처리해야할 작업 n 개, 이를 처리하기 위한 core 수(처리 시간 다름)
         * 2개 이상 코어 다를 시 앞의 코어부터 처리
         * 마지막 작업을 처리하는 코어 번호는?
         */

        int numOfCores = cores.length;

        if(n <= numOfCores) return n;

        long left = 0;
        long right = (long) n * getMaxCore(cores);

        //마지막 작업을 처리하는 시간을 변수로 두고, 이 변수의 최소값을 찾는다.
        while(left <= right){

            long mid = left + (right - left) / 2;
            int count = numOfCores;

            //걸리는 시간이 mid, 각 코어가 처리하는 작업의 수는 T/cores[i]
            for(int core : cores) count += mid / core;

            //가능하다면 전체 소요 시간을 줄인다.
            if(count >= n) right = mid - 1;
            else left = mid + 1;

        }

        long time = left;
        long count = numOfCores;

        for(int core : cores){
            count += (time - 1) / core;
        }

        //시간 T에 완료되는 코어 순서대로 확인
        for(int i = 0 ; i < numOfCores ; i++){
            if(time % cores[i] == 0){
                count++;

                if(count == n) return i + 1; //i+1번째
            }
        }


        return -1;
    }

    private int getMaxCore(int[] cores){

        int max = 0;

        for(int core : cores) max = Math.max(core, max);

        return max;
    }
}
