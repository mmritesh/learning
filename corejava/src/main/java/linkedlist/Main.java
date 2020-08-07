package linkedlist;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.insert(4);
        linkedList.display();
        System.out.println();
        linkedList.reverse();
        linkedList.display();
        System.out.println();

        System.out.println("-----");

        System.out.println("ReversedLinkedList: " + reverseLinkedList(Arrays.asList(1, 2, 3, 4)));
    }

    private static List<Integer> reverseLinkedList(List<Integer> list) {
        LinkedList linkedList = new LinkedList(list);
        linkedList.reverse();
        return linkedList.getAsList();
    }
}
