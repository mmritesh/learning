package main.java.multipleinheritance.usinginterfaces;

import main.java.multipleinheritance.usinginterfaces.Parent1;
import main.java.multipleinheritance.usinginterfaces.Parent2;

public class ConcreteChild implements Parent1, Parent2 {
    @Override
    public void show() {
        Parent1.super.print();
        Parent2.super.print();
    }

    /**
     * in case of multiple inheritance using interfaces
     * we have to implement this default method in concrete class as well, else it will be a compile time error
     */
    public void print() {
        Parent1.super.print();
        Parent2.super.print();
    }
    public static void main(String[] args) {
        Parent1 parent1 = new ConcreteChild();
        parent1.print();
//        parent1.print();
    }
}
