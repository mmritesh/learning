package heap.api;

public interface Heapify<T> {
    Heap<T> heapifyUp(Heap<T> heap);

    Heap<T> heapifyDown(Heap<T> heap);
}
