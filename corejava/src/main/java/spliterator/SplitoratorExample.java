package spliterator;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class SplitoratorExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        Spliterator<Integer> spliterator = list.spliterator();
        spliterator.forEachRemaining(integer -> {
            System.out.println(integer + " ");
        });
    }
}
