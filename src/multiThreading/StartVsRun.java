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

    start() ->
            Creates a new OS-level thread.
            Runs code in a separate, new call stack.
            Throws IllegalThreadStateException if called twice.
            Enables asynchronous, parallel execution.

    run() ->
            Does not create a new thread.
            Runs code inside the current calling thread (e.g., main).
            Can be called multiple times like a standard method.
            Forces sequential, blocking execution
 */