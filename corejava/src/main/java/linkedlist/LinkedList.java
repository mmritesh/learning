package linkedlist;

import java.util.ArrayList;
import java.util.List;

public class LinkedList {
    private ListNode head;

    public LinkedList() {
    }

    public LinkedList(List<Integer> list) {
        list.forEach(this::insert);
    }

    public void insert(int item) {
        if (head == null) {
            head = new ListNode(item);
            return;
        }
        ListNode ptr = head;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = new ListNode(item);
    }

    public void display() {
        ListNode ptr = head;
        while (ptr.next != null) {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }
        System.out.print(ptr.data);
    }

    public List<Integer> getAsList() {
        ListNode ptr = head;
        List<Integer> result = new ArrayList<>();
        while (ptr.next != null) {
            result.add(ptr.data);
            ptr = ptr.next;
        }
        result.add(ptr.data);
        return result;
    }

    // head -> 1 -> 2 -> 3 -> null
    // null <- 1 <- 2 <- 3 <- head

    /**
     * Given starting scenario i.e. pointer to head and a futureNext to null and future pointer to the next node.
     */
    public void reverse() {
        ListNode ptr = head;
        ListNode next = null;
        ListNode temp = ptr.next;

        while (ptr.next != null) {
            ptr.next = next;
            next = ptr;
            ptr = temp;
            temp = ptr.next;
        }
        ptr.next = next;
        head = ptr;
    }



}
