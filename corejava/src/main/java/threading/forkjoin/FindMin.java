package threading.forkjoin;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * First we check if the current size of the problem is bigger than a given threshold. If this is the case,
 * we divide the problem into smaller problems, fork() each new task and then wait for the results by calling join().
 * As join() returns the results for each subtask, we have to find the best solution of the smaller problems and return
 * this as our best solution. These steps are repeated until the given threshold is too low and the problem so small
 * that we can compute its solution directly without further division.
 */

/**
 * ExecutorService vs ForkJoin
 * The main difference between both implementations can be found at the point where the thread pool is constructed.
 * In the example above, we create a fixed thread pool with 64(!) threads. Why did I choose such a big number?
 * The reason here is, that calling get() for each returned Future block the current thread until the result is available.
 * If we would only provide as many threads to the pool as we have CPUs available, the program would run out of resources
 * and hang indefinitely.
 * The ForkJoinPool implements the already mentioned work-stealing strategy, i.e. every time a running thread has to wait
 * for some result; the thread removes the current task from the work queue and executes some other task ready to run.
 * This way the current thread is not blocked and can be used to execute other tasks. Once the result for the originally
 * suspended task has been computed the task gets executed again and the join() method returns the result.
 * This is an important difference to the normal ExecutorService where you would have to block the current
 * thread while waiting for a result.
 */
public class FindMin extends RecursiveTask<Integer> {
    private static final long serialVersionUID = 1L;
    private int[] numbers;
    private int startIndex;
    private int endIndex;

    public FindMin(int[] numbers, int startIndex, int endIndex) {
        this.numbers = numbers;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public static void main(String[] args) {
        int[] numbers = new int[100];
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100);
        }
        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        Integer min = pool.invoke(new FindMin(numbers, 0, numbers.length - 1));
        System.out.println(min);
    }

    @Override
    protected Integer compute() {
        int sliceLength = (endIndex - startIndex) + 1;
        if (sliceLength > 2) {
            FindMin lowerFindMin = new FindMin(numbers, startIndex, startIndex + (sliceLength / 2) - 1);
            lowerFindMin.fork();
            FindMin upperFindMin = new FindMin(numbers, startIndex + ( sliceLength / 2),endIndex);
            upperFindMin.fork();
            return Math.min(lowerFindMin.join(), upperFindMin.join());
        } else {
            return Math.min(numbers[startIndex], numbers[endIndex]);
        }

    }
}