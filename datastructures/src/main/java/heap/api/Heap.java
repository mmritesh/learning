package heap.api;

import java.util.List;

public interface Heap<T> {
    enum Type {
        MIN_HEAP, MAX_HEAP;
    }
    T peek(int index);
    T pop(int index);
    void add(T item);
    void print();
    List<T> getItems();
    int getSize();
    Type getType();
}
