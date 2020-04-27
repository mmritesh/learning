package main.java.multipleinheritance.usinginterfaces;

public interface Parent2 {
    int property1 = 1;

    default void print() {
        System.out.println("This is " + this.getClass().getName());
    }
    void show();
}
