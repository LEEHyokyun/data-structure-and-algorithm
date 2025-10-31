package algorithm.heapSort;

import algorithm.heapSort.heap.BinaryTree;
import algorithm.heapSort.heap.Heap;

public class HeapSort {
    private int data;
    private int priority;

    public HeapSort(int data){
        this.data = data;
        this.priority = data;
    }

    public void heapSort(){
        Heap heap = new Heap(null, null);
        heap.insert(2);
        heap.insert(8);
        heap.insert(5);

        int[] intArrary = new int[3];

        intArrary[0] = heap.remove().getData();
        intArrary[1] = heap.remove().getData();
        intArrary[2] = heap.remove().getData();
    }
}
