package week37;

public class DeliveryAndPickupByDP {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {

        /*
         * n개 집에 택배 배달 + 빈 재활용 택배 상자 수거
         * i -> j = 거리 j - i
         * 최대 cap개 재활용 상자 수거 가능
         * 트럭 = 각 집 배달 + 수거
         * 트럭 하나로 모든 배달과 수거를 마치고 물류창고로 돌아올 수 있는 최소 이동 거리
         */

        /*
         * 한번왕복으로 최대한 많은 택배를 전달하거나 수거해야 함
         */

        long answer = 0;
        long delivery = 0;
        long pickup = 0;

        for(int i = n - 1 ; i >= 0 ; i--){

            delivery += deliveries[i];
            pickup += pickups[i];

            while(delivery > 0 || pickup > 0){

                delivery -= cap;
                pickup -= cap;

                answer += (long) (i+1) * 2; //거리 = 왕복 거리이므로 *2
            }

        }

        return answer;
    }
}
