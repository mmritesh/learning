package heap.api;

import java.util.Arrays;

public abstract class AbstractArrayHeap<T extends Comparable<T>> implements Heap<T> {

    protected int capacity = 20;
    protected T[] items;
    protected int size;
    protected Type type;

    protected int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }
    protected int getRightChildIndex(int index) {
        return 2 * index + 2;
    }
    protected int getParentIndex(int index) {
        return (index - 1) /2;
    }

    protected boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < getSize();
    }
    protected boolean hasRightChild(int index) {
        return getRightChildIndex(index) < getSize();
    }
    protected boolean hasParent(int index) {
        return getRightChildIndex(index) >= 0;
    }

    protected T leftChild(int index) {
        return items[getRightChildIndex(index)];
    }
    protected T rightChild(int index) {
        return items[getRightChildIndex(index)];
    }
    protected T parent(int index) {
        return items[getParentIndex(index)];
    }
    protected void ensureExtraCapacity() {
        if (size == capacity) {
            capacity *= 2;
            items = Arrays.copyOf(items, capacity);
        }
    }
    protected void swap(int index1, int index2) {
        T temp = items[index1];
        items[index1] = items[index2];
        items[index2] = temp;
    }
}
