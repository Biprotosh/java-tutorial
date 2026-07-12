package multiThreading.locksTut;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionsTut {
    public static void main(String[] args) {
        Box b = new Box();

        // producers
        Thread p1 = new Thread(() -> {
            try{
                Thread.sleep(100);
                b.producer(6);
            }catch (Exception e) {}
        });

        Thread p2 = new Thread(() -> {
            try{
                Thread.sleep(100);
                b.producer(8);
            }catch (Exception e) {}
        });

        Thread p3 = new Thread(() -> {
            try{
                Thread.sleep(100);
                b.producer(3);
            }catch (Exception e) {}
        });

        // consumers
        Thread c1 = new Thread(() -> {
            try{
                Thread.sleep(100);
                b.consumer();
            }catch (Exception e) {}
        });

        Thread c2 = new Thread(() -> {
            try{
                Thread.sleep(100);
                b.consumer();
            }catch (Exception e) {}
        });

        Thread c3 = new Thread(() -> {
            try{
                Thread.sleep(100);
                b.consumer();
            }catch (Exception e) {}
        });

        p1.start();
        p2.start();
        p3.start();

        c1.start();
        c2.start();
        c3.start();
    }
}

class Box{
    private volatile Integer value;
    private volatile boolean flag;

    Lock l1 = new ReentrantLock(true); // fair lock
    Condition producerCondition = l1.newCondition(); // waiting area for producers
    Condition consumerCondition = l1.newCondition(); // waiting area for consumers

    public void producer(int value) throws InterruptedException {
        l1.lock();
        try{
            while (flag){
                producerCondition.await();
            }

            this.value = value;
            this.flag = true;

            System.out.println(Thread.currentThread().getName() + " produced: " + value);
            consumerCondition.signalAll();
        }finally {
            l1.unlock();
        }
    }

    public void consumer() throws InterruptedException {
        l1.lock();

        try{
            while (!flag) {
                consumerCondition.await();
            }

            System.out.println(Thread.currentThread().getName() + " consumed: " + value);

            this.value = null;
            this.flag = false;
            producerCondition.signalAll();
        }finally {
            l1.unlock();
        }
    }
}

/*
    When is signal() actually safe?
    Only 1 producer + 1 consumer. When there is exactly ONE thread on each side, signal() is deterministic. There is only one thread to wake — no ambiguity,
    no wrong picks. All waiting threads are identical. If every sleeping thread in a condition queue would do exactly the same thing when woken,
    it doesn't matter which one you pick. signal() is safe.

    Any other case:
    Use signalAll(). The performance cost is tiny. The safety gain is total.
 */