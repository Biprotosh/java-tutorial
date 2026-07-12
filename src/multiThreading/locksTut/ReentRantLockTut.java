package multiThreading.locksTut;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentRantLockTut {
    public static void main(String[] args) {
        Resource r1 = new Resource();

        Thread t1 = new Thread(r1::f1);
        Thread t2 = new Thread(r1::f1);
        Thread t3 = new Thread(r1::f1);

        t1.start();
        t2.start();
        t3.start();
    }
}

class Resource{

    Lock lock = new ReentrantLock(); // Reentrant means reenters something multiple times

    void f1(){
        lock.lock();
        // critical section starts
        try{
            System.out.println(Thread.currentThread().getName() + " entered");

            try{
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().getName() + " exited");
        }
        //critical section ends
        finally {
            lock.unlock();
        }

    }
}
