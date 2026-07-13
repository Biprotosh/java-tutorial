package multiThreading.executerCollectionFramework;

import java.awt.desktop.SystemEventListener;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureTut {
    public static void main(String[] args) {

        CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(() -> {
            return 10;
        }).thenApply(res -> res*2).thenApply(res -> res*2);

        try{
            System.out.println(f1.get());
        }catch (Exception e){}

        CompletableFuture<Void> f2 = CompletableFuture.supplyAsync(() -> {
            return 10;
        }).thenAccept(System.out::println); // it consumes a value, so type Integer is useless, that's why used Void

        CompletableFuture<Void> f3 = CompletableFuture.supplyAsync(() -> {
            return 54;
        }).thenRun(() -> System.out.println("Done")); // runnable lamda don't have parameter

        CompletableFuture<Integer> f4 = CompletableFuture.supplyAsync(() -> 8);
        CompletableFuture<Integer> f5 = CompletableFuture.supplyAsync(() -> 7);
        CompletableFuture<Void> f6 = f4.thenCombine(f5, Integer::sum).thenAccept(System.out::println);
    }
}

/*
    CompletableFuture internally works with fork join pool that's why we don't need to use external executer
 */