package basic.hashSet;

public class Node {
    private HashData data;
    private Node nextNode;
    private Node prevNode;

    public Node(HashData data, Node nextNode, Node prevNode) {
        this.data = data;
        this.nextNode = nextNode;
        this.prevNode = prevNode;
    }

    public HashData getData(){
        return data;
    }

    public void setData(HashData data){
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
