package heap.problems;

import heap.api.Heap;
import heap.api.impl.MaxArrayHeap;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MaxElementInSlidingWindow {

    public List<Integer> solveUsingHeap(List<Integer> a, int w) {
        Heap<Integer> heap = new MaxArrayHeap<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < w; i++) {
            heap.add(a.get(i));
        }
        for (int i = w; i < a.size(); i++) {
            result.add(heap.remove(0));
            heap.add(a.get(i));
        }
        return result;
    }

    public List<Integer> solveUsingDequeue(List<Integer> a, int w) {
        Deque<Integer> deque = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < w; i++) {
            while (isCurrentElementGreaterThanQueueLast(deque, a, i)) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        for (int i = w; i < a.size(); i++) {
            result.add(a.get(deque.getFirst()));
            while (isCurrentElementGreaterThanQueueLast(deque, a, i)) {
                deque.removeLast();
            }
            while (isFrontElementFromTheQueueInValid(deque, a, i, w)) {
                deque.removeFirst();
            }
            deque.addLast(i);
        }
        return result;
    }

    private boolean isFrontElementFromTheQueueInValid(Deque<Integer> deque, List<Integer> a, int i, int w) {
        return !deque.isEmpty() && deque.getFirst() <= i-w;
    }

    private boolean isCurrentElementGreaterThanQueueLast(Deque<Integer> deque, List<Integer> a, int i) {
        return !deque.isEmpty() && a.get(i) >= a.get(deque.peekLast());
    }


}
