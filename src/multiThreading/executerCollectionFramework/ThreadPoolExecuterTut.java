package multiThreading.executerCollectionFramework;

import java.util.concurrent.*;

public class ThreadPoolExecuterTut {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                5,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2));

        for(int i=1; i<=5; i++){
            int taskId = i;
            executor.execute(() -> {
                System.out.println("Task: " + taskId + " is performed by " + Thread.currentThread().getName());

                try{
                    Thread.sleep(2000);
                }catch (InterruptedException e){}
            });
        }

        executor.shutdown();
    }
}
