package multiThreading.problemsWithMultithreading;

public class ProblemOfVisibility {
//    static boolean flag = false;
    static volatile boolean flag = false;
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // t1 set flag to true in t1s cache and if there is a write operation in cache it propagate to RAM, rule of OS
            flag = true;
        });
        Thread t2 = new Thread(() -> {
            // it reads the value of flag not from main memory but from the cache memory of the CPU
            while (!flag){
//                System.out.println("Thread 2 running..."); // print statement is synchronized. if forces cpu to flush its cache
            }
            System.out.println("Thread 2 finished");
        });

        t1.start();
        t2.start();
    }
}

/*
    The problem of visibility can be solved using the keyword volatile.
    it says always read from RAM not any cache
 */
