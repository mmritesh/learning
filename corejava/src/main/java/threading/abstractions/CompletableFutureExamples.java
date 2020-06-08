package threading.abstractions;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The Future interface was added in Java 5 to serve as a result of an asynchronous computation,
 * but it did not have any methods to combine these computations or handle possible errors.
 *
 * In Java 8, the CompletableFuture class was introduced. Along with the Future interface, it also implemented the
 * CompletionStage interface. This interface defines the contract for an asynchronous computation step that can be
 * combined with other steps.
 *
 * CompletableFuture is at the same time a building block and a framework with about 50 different methods for composing,
 * combining, executing asynchronous computation steps and handling errors.
 */
public class CompletableFutureExamples {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");
        completableFuture
                .thenApply(s -> {
                    /*
                      Executed in the same thread where the supplyAsync() task is executed
                      or in the main thread If the supplyAsync() task completes immediately (Remove sleep() call to verify)
                    */
                    return s + " World";
                })
                .thenApplyAsync(s -> {
                    // Executed in a different thread from ForkJoinPool.commonPool()
                    return s + " Applied async";
                })
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + ", Ritesh."))
                .thenCombine(CompletableFuture.supplyAsync(() -> "\n Welcome to Multithreading"), (s, s2) -> s + s2)
                .thenAccept(System.out::println);

        // Combining multiple completable futures.
        CompletableFuture<String> future1
                = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2
                = CompletableFuture.supplyAsync(() -> "Beautiful");
        CompletableFuture<String> future3
                = CompletableFuture.supplyAsync(() -> "World");

        CompletableFuture
                .allOf(future1, future2, future3);

        String combined = Stream.of(future1, future2, future3)
                .map(CompletableFuture::join)
                .collect(Collectors.joining(" "));
        System.out.println(combined);


        // Exception Handling

        Integer age = -1;

        CompletableFuture<String> maturityFuture = CompletableFuture.supplyAsync(() -> {
            if(age < 0) {
                throw new IllegalArgumentException("Age can not be negative");
            }
            if(age > 18) {
                return "Adult";
            } else {
                return "Child";
            }
        }).exceptionally(ex -> {
            System.out.println("Oops! We have an exception - " + ex.getMessage());
            return "Unknown!";
        }).handle((res, ex) -> {
            // If an exception occurs, then the res argument will be null,
            // otherwise, the ex argument will be null.
            if(ex != null) {
                System.out.println("Oops! We have an exception - " + ex.getMessage());
                return "Unknown!";
            }
            return res;
        });
        System.out.println("Maturity : " + maturityFuture.get());

    }

}
