package stack.model;

import linkedlist.model.ListNode;

public class Stack<T> {
    private int length;
    private ListNode<T> top;

    public Stack() {
        length = 0;
        top = null;
    }

    public boolean isEmpty() {
        return length == 0;
    }
    public int size() {
        return length;
    }
    public void push(T data) {
        ListNode node = new ListNode(data);
        node.setNext(top);
        top = node;
        length++;
    }
    public T pop() throws RuntimeException {
        if (isEmpty()) {
            throw new RuntimeException("Empty Stack Exception.");
        }
        T data = top.getData();
        top = top.getNext();
        length--;
        return data;
    }
    public T peek() throws RuntimeException{
        if (isEmpty()) {
            throw new RuntimeException("Empty Stack Exception.");
        }
        return top.getData();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder().append("top -> ");
        ListNode ptr = top;
        while (ptr != null) {
            res.append(ptr.getData()).append(", ");
            ptr = ptr.getNext();
        }
        return res.toString();
    }
}
