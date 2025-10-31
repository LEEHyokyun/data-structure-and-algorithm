package algorithm.priorityQueue;

import algorithm.priorityQueue.heap.Heap;

public class PriorityQueue {
    private Heap heap;

    public PriorityQueue(Heap heap){
        this.heap = heap;
    }

    public void enqueue(int data){
        this.heap.insert(data);
    }

    public int dequeue(){
         return this.heap.remove().getData();
    }
}
