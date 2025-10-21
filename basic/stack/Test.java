package basic.linkedList;

import java.util.ArrayList;

public class Test {
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

        //insertAt
        LinkedList linkedList = new LinkedList(new Node("first", null));
        linkedList.insertAt(0L, "index 0");
        linkedList.insertAt(1L, "index 1");
        linkedList.insertAt(2L, "index 2");
        linkedList.insertAt(3L, "index 3");

        //printAll
        linkedList.printAll();

        //clear
        linkedList.clear();
        linkedList.printAll();

        //insertAtLast
        linkedList.insertLast("last");
        linkedList.insertLast("last2");
        linkedList.insertLast("last3");
        linkedList.printAll();

        //deleteAt
        linkedList.deleteAt(0L);
        linkedList.deleteAt(1L);
        linkedList.deleteAt(2L);
        linkedList.printAll();

        //deleteLast
        linkedList.deleteLast();

        //getNodeAt
        linkedList.getNodeAt(0L);

    }
}
