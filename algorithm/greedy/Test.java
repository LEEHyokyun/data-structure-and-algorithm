package algorithm.greedy;

import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        Coin coin500 = new Coin(500);
        Coin coin100 = new Coin(100);
        Coin coin50 = new Coin(50);
        Coin coin10 = new Coin(10);

        LinkedList<Coin> coins = new LinkedList<>();
        coins.add(coin500);
        coins.add(coin100);
        coins.add(coin50);
        coins.add(coin10);

        Greedy greedy = new Greedy();
        greedy.greedy(2380, coins);
    }
}
