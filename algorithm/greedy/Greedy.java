package algorithm.greedy;

import java.util.LinkedList;

public class Greedy {
    public void greedy(int money, LinkedList<Coin> coins) {
        for(int i = 0 ; i < coins.size() ; i++){
            while(coins.get(i).getValue() <= money){
                coins.get(i).setCount(coins.get(i).getCount() + 1);
                money -= coins.get(i).getValue();
            }
        }

        coins.stream().forEach(coin -> System.out.println(coin.getValue() +" 동전은 " + coin.getCount()+ "개"));
    }
}
