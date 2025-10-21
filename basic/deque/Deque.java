package basic.deque;

public class Deque {
    private DoublyLinkedList doublyLinkedList = new DoublyLinkedList(null, null);

    public Deque(DoublyLinkedList doublyLinkedList){
        this.doublyLinkedList = doublyLinkedList;
    }

    //1
    public void printAll(){
        this.doublyLinkedList.printAll();
    }

    //2
    public void addFirst(String data){
        this.doublyLinkedList.insertAt(0L, data);
    }

    //3
    public void removeFirst(){
        this.doublyLinkedList.deleteAt(0L);
    }

    //4
    public void addLast(String data){
        this.doublyLinkedList.insertAt(this.doublyLinkedList.getCount(), data);
    }

    //5
    public void removeLast(){
        this.doublyLinkedList.deleteLast();
    }

    //6
    public boolean isEmpty(){
        return this.doublyLinkedList.getCount() == 0;
    }
}
