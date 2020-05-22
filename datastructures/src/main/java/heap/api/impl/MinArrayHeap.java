package heap.api.impl;

import heap.api.AbstractArrayHeap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MinArrayHeap<T extends Comparable<T>> extends AbstractArrayHeap<T> {

    @SuppressWarnings("unchecked")
    public MinArrayHeap() {
        type = Type.MIN_HEAP;
        items = (T[]) new Comparable[capacity];
;    }

    @Override
    public T peek(int index) {
        if(size == 0) throw new IllegalStateException();
        return items[0];
    }

    @Override
    public T remove(int index) {
        if (size == 0) throw new IllegalStateException();
        if(index >= size || index < 0) throw new IllegalArgumentException();
        T temp = items[index];
        items[index] = items[size - 1];
        size--;
        heapifyDown(index);
        return temp;
    }

    @Override
    public void add(T item) {
        ensureExtraCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    @Override
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(items[i] + " ");
        }
    }

    @Override
    public List<T> getItems() {
        return Arrays.stream(items).skip(0).limit(size).collect(Collectors.toList());
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Type getType() {
        return type;
    }

    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && parent(index).compareTo(items[index]) > 0) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private void heapifyDown(int index) {
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index).compareTo(leftChild(index)) < 0) {
                smallerChildIndex = getRightChildIndex(index);
            }
            if (items[smallerChildIndex].compareTo(items[index]) > 0) {
                break;
            }
            swap(index, smallerChildIndex);
            index = smallerChildIndex;
        }
    }

}
