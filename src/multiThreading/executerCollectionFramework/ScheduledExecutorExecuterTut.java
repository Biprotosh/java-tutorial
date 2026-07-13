package multiThreading.executerCollectionFramework;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorExecuterTut {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

//        for(int i = 1; i <= 5; i++){
//            int taskId = i;
//            scheduler.schedule(() -> {
//                System.out.println("Task: " + taskId + " is performed by " + Thread.currentThread().getName());
//            }, 2, TimeUnit.SECONDS);
//        }

        scheduler.scheduleAtFixedRate(() -> {
                System.out.println("Task:  is performed by " + Thread.currentThread().getName());
        }, 0, 2, TimeUnit.SECONDS);

        scheduler.shutdown();
    }
}
