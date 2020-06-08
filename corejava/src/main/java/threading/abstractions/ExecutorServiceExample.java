package threading.abstractions;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Runnable task= () -> System.out.println("runnable task");

        ExecutorService executorService= Executors.newSingleThreadExecutor();
        Future future=    executorService.submit(task);
        System.out.println("value - "+ future.get());  //returns null if the task has finished successfully


        Callable<String> task2 = () -> "task 2 ";
        executorService = Executors.newSingleThreadExecutor();
        future = executorService.submit(task2);
        System.out.println("value - "+ future.get()); //returns task1
    }
}
