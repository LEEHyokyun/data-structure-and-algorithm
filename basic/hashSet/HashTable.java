package basic.hashSet;

import basic.hashSet.DoublyLinkedList;
import basic.hashSet.HashData;
import basic.hashSet.Node;

/*
* generic 사용하고 싶다면 반드시 선언부에서 먼저 선언 필요함.
* */
public class HashTable {
    private DoublyLinkedList[] list =  new DoublyLinkedList[10];

    //set
    public void set(int key, String data) {
        this.list[this.hashFunction(key)].insertAt(0, new HashData(key, data));
    }

    //get
    public String get(int key){
        Node currentNode = this.list[this.hashFunction(key)].getHead();

        while(currentNode != null){
            if(currentNode.getData().getKey() == key){
                return currentNode.getData().getData();
            }else{
                currentNode = currentNode.getPrevNode();
            }
        }

        return null;
    }

    //remove("데이터"의 제거)
    public void remove(int key){
        DoublyLinkedList doublyLinkedList = this.list[this.hashFunction(key)];
        Node currentNode = doublyLinkedList.getHead();
        int currentIndex = 0;


        while(currentNode != null){
            if(currentNode.getData().getKey() == key){
                doublyLinkedList.deleteAt(currentIndex);
            }
            currentNode = currentNode.getNextNode();
            currentIndex++;
        }

        if(currentNode == null)
            System.out.println("해당 key는 존재하지 않습니다.");
    }

    //hash function
    private int hashFunction(int number){
        return number % 10;
    }

    //getter
    public DoublyLinkedList[] getList(){
        return this.list;
    }
}
