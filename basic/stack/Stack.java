package basic.stack;

import basic.linkedList.LinkedList;
import basic.linkedList.Node;

public class Stack {
    private LinkedList linkedList = new LinkedList(new Node("1", null));

    public Stack(LinkedList linkedList){
        this.linkedList = linkedList;
    }

    //1
    public void push(String data){
        this.linkedList.insertAt(0L, "1");
    }

    //2
    public void pop(){
        try {
            this.linkedList.deleteAt(0L);
        } catch(Exception e){
            throw new RuntimeException("<UNK>");
        }
    }

    //3
    public void peek(){
        this.linkedList.getNodeAt(0L);
    }

    //4
    public boolean isEmpty(){
        return this.linkedList.getCount() == 0;
    }
}
