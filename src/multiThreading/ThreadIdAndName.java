package multiThreading;

public class ThreadIdAndName {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().threadId()); // .getId() is deprecated

        Thread t1 = new Thread(() -> {
            System.out.println("Name of my 1st thread is: " + Thread.currentThread().getName());
            System.out.println("Id of my 1st thread is: " + Thread.currentThread().threadId());
        });

        Thread t2 = new Thread(() -> {
            System.out.println("Name of my 2nd thread is: " + Thread.currentThread().getName());
            System.out.println("Id of my 2nd thread is: " + Thread.currentThread().threadId());
        });

        t1.start(); // we need to call this otherwise thread won't be created by OS
        t2.start();
    }
}

/*
    We use getName() for logging purpose
    Multithreading code gets too complicated to debug, so a unique name and id can make the task a lot easier.
    Thread doesn't follow any order, it can randomly run by CPU
 */