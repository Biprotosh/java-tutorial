package multiThreading.executerCollectionFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingExecuterFramework {
    public static void main(String[] args) {
        // A fixed thread pool with 2 workers
        ExecutorService executer = Executors.newFixedThreadPool(2);

        // number of tasks 5
        for(int i = 1; i <= 5; i++){
            int taskId = i;
            executer.execute(() -> {
                System.out.println("Task: " + taskId + " is performed by " + Thread.currentThread().getName());
            });
        }

        executer.shutdown(); // important method, otherwise thread will be alive even after program terminates
    }
}
