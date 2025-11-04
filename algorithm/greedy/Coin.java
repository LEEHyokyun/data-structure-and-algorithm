package algorithm.greedy;

public class Coin {
    private int value;
    private int count;

    public Coin(int value) {
        this.value = value;
        this.count = 0;
    }

    public int getValue() {
        return this.value;
    }

    public int getCount(){
        return this.count;
    }

    public void setCount(int count){
        this.count = count;
    }
}
