package basic.linkedList;

public class LinkedList {
    public static void main(String args[]){
        //Node 객체
        Node node1 = new Node("1", null );
        Node node2 = new Node("2", null );
        Node node3 = new Node("3", null );

        //연결
        node1.setNextNode(node2);
        node2.setNextNode(node3);

        System.out.println(node1.getData());
        System.out.println(node1.getNextNode().getData());
        System.out.println(node1.getNextNode().getNextNode().getData());
    }
}
