package algorithm.maximumFlow;

/*
* 포트풀커슨 알고리즘은 보완이 필요하다.
* */
public class FlowAndCapacity {
    private int flow;
    private int capacity;

    public FlowAndCapacity(int flow, int capacity) {
        this.flow = flow;
        this.capacity = capacity;
    }

    public int getFlow() {
        return this.flow;
    }

    public void setFlow(int flow) {
        this.flow = flow;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public void setCapacity(int capacity){
        this.capacity = capacity;
    }
}
