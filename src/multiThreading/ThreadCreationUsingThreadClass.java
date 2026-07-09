package multiThreading;

public class ThreadCreationUsingThreadClass {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
    }
}

// Thread class extend
class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println("Thread is running");
    }
}

/*
    By-default we have main thread in java. Thread class internally implements runnable interface
    t1.start() -> jvm asks OS to create a new thread. Thread get its own stack and pc
    then thread execute run method
 */
