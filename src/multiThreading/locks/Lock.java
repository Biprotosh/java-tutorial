package multiThreading.locks;

public class Lock {
    public static void main(String[] args) {
        Test tst = new Test();

        Thread t1 = new Thread(() -> {
            tst.show();
        });
        Thread t2 = new Thread(() -> {
            tst.show();
        });

        t1.start();
        t2.start();
    }
}

class Test{

    // without synchronized both the threads enters the critical section at the same time
    synchronized void show(){
        System.out.println(Thread.currentThread().getName() + " inside show");

        try{
            Thread.sleep(2000);
        }catch (InterruptedException e) {}

        System.out.println("Show finish");
    }
}

/*
    synchronized makes our code slow because it comes with overhead, so in production we use better locking mechanism
 */
