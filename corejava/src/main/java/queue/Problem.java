package queue;

public class Problem {
    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);

        while (!queue.isEmpty()) {
            System.out.print(queue.pop() + " ");
        }
    }

}
