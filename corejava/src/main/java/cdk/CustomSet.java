package cdk;

public interface CustomSet<T> {
    void add(T item);
    boolean remove(T item);
    boolean contains(T item);
}
