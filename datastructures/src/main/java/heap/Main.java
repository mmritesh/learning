package heap;

import heap.api.Heap;
import heap.api.impl.MinArrayHeap;

public class Main {

    public static void main(String[] args) {
        Heap<Integer> minHeap = new MinArrayHeap<>();
        minHeap.add(10);
        minHeap.add(9);
        minHeap.add(8);
        minHeap.add(7);
        minHeap.add(6);

        System.out.println("Min Heap: " + minHeap.getItems());
    }
}
