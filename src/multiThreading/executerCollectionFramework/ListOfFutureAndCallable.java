package multiThreading.executerCollectionFramework;

import java.util.List;
import java.util.concurrent.*;

public class ListOfFutureAndCallable {
    public static void main(String[] args) {
        try(ExecutorService executor = Executors.newFixedThreadPool(3)){

            List<Callable<Integer>> tasks = List.of(
                    () -> 10,
                    () -> 20,
                    () -> 30,
                    () -> 50,
                    () -> 60,
                    () -> 840
            );

            List<Future<Integer>> f = executor.invokeAll(tasks);

            for(Future<Integer> val : f){
                System.out.println(val.get());
            }

        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
