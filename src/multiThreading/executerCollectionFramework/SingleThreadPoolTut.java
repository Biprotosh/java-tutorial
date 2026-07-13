package multiThreading.executerCollectionFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadPoolTut {
    public static void main(String[] args) {
        try(ExecutorService execute = Executors.newSingleThreadExecutor()){
            for(int i = 1; i <= 10; i++){
                int taskId = i;
                execute.execute(() -> {
                    System.out.println("Task: " + taskId + " is performed by " + Thread.currentThread().getName());
                });

                try{
                    Thread.sleep(200);
                }catch (InterruptedException e){}
            }
        }
    }
}
