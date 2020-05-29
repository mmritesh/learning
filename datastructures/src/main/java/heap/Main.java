package heap;

import heap.api.Heap;
import heap.api.impl.MinArrayHeap;
import heap.problems.MaxElementInSlidingWindow;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Heap<Integer> minHeap = new MinArrayHeap<>();
        minHeap.add(10);
        minHeap.add(9);
        minHeap.add(8);
        minHeap.add(7);
        minHeap.add(6);

//        minHeap.remove(0);
        minHeap.remove(1);
        System.out.println("Min Heap: " + minHeap.getItems());

        MaxElementInSlidingWindow maxElementInSlidingWindow = new MaxElementInSlidingWindow();
        List<Integer> list = Arrays.asList(1, 3, -1, -3, 5, 3, 6, 7);
        int w = 3;
        System.out.println("Find Max element in window: Given array: " +  list + " windowSize: " + w + " ans: " + maxElementInSlidingWindow.solveUsingHeap(list, w));
        System.out.println("Find Max element in window: Given array: " +  list + " windowSize: " + w + " ans: " + maxElementInSlidingWindow.solveUsingDequeue(list, w));
    }
}
