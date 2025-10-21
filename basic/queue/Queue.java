package basic.queue;

import basic.doublyLinkedList.DoublyLinkedList;
import basic.doublyLinkedList.Node;

public class Queue {
    private DoublyLinkedList doublyLinkedList = new DoublyLinkedList(null, null);

    public Queue(DoublyLinkedList doublyLinkedList){
        this.doublyLinkedList = doublyLinkedList;
    }

    //1
    public void enqueue(){
        this.doublyLinkedList.insertAt(0L, "enqueue");
    }

    //2
    public void dequeue(){
        try {
            this.doublyLinkedList.deleteLast();
        } catch(Exception e){
            throw new RuntimeException("<UNK>");
        }
    }

    //3
    public void front(){
        this.doublyLinkedList.getTail();
    }

    //4
    public boolean isEmpty(){
        return this.doublyLinkedList.getCount() == 0;
    }
}
