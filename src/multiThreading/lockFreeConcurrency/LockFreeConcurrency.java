package multiThreading.lockFreeConcurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class LockFreeConcurrency {
    public static void main(String[] args) {
        Counter c = new Counter();

        Thread t1 = new Thread(() -> {
            for(int i = 1; i <= 10000; i++){
                c.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i = 1; i <= 10000; i++){
                c.increment();
            }
        });

        t1.start();
        t2.start();

        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){}
        System.out.println(c.cnt);
    }
}

// AtomicInteger
class Counter{
//    int cnt = 0;

    AtomicInteger cnt = new AtomicInteger(0);
    void increment(){
//        cnt++;
        cnt.incrementAndGet(); // ++cnt. It is an atomic operation. This operation will be executed by a thread either fully or not
    }
}

/*
    It internally uses compare and set (CAM) operation to handle concurrent and parallel execution of threads
    AtomicInteger methods ->
        get() for get int val
        set() for set int val
        incrementAndGet() ++cnt
        getAndIncrement() cnt++
        addAndGet(value) x = x + 4
 */