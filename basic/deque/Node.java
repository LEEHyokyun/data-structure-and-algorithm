package basic.deque;

public class Node {
    private String data;
    private Node nextNode;
    private Node prevNode;

    public Node(String data, Node nextNode, Node prevNode) {
        this.data = data;
        this.nextNode = nextNode;
        this.prevNode = prevNode;
    }

    public String getData(){
        return data;
    }

    public void setData(String data){
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public Node getPrevNode() { return prevNode; }

    public void setPrevNode(Node prevNode) { this.prevNode = prevNode; }
}
