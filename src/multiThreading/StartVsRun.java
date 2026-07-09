package multiThreading;

public class StartVsRun {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("Current thread is: " + Thread.currentThread().getName());
        });

        t1.start(); // it internally calls run() method
//        t1.start();
//        t1.run();
    }
}

/*
    Can we start the same thread twice?
    -> No, if we try compiler will give IllegalThreadStateException
 */