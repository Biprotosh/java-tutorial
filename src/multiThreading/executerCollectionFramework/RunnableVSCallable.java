package multiThreading.executerCollectionFramework;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RunnableVSCallable {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2); // Internally uses ThreadPoolExecuter

//        try{
//            executor.execute(() -> {
//                int x = 10 / 0;
//            });
//        }catch (ArithmeticException e){} // can't catch the exception because runnable don't return.

        Future<Integer> f1 = executor.submit(() -> {
            return 10 / 0;
        });

        try{
            System.out.println(f1.get());
        }catch (InterruptedException | ExecutionException e){
            System.out.println(e.getMessage());
        }

        executor.shutdown();
    }
}
