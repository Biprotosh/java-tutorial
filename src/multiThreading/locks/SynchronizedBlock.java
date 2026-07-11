package multiThreading.locks;

public class SynchronizedBlock {
    public static void main(String[] args) {
        Counter1 c1 = new Counter1();

        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 1000; i++)
                c1.increment();
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 1000; i++)
                c1.increment();
        });

        /*
            Excepting cnt should be 2000 but most of the time it will give result lesser than 2000
         */

        t1.start();
        t2.start();

        // pausing main thread
        try{
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(c1.cnt);
    }
}

class Counter1{
    public int cnt = 0;

    void increment(){
        // normal code

        synchronized (this){
            cnt++;
        }

        // normal code
    }
}

/*
    synchronized blocked is used to make a part of code a critical section instead of making full method a critical section.
    It is helpful because synchronized comes with overhead where it needs to acquire lock, release it. So it would be better
    we only make synchronize the code which is actually comes under critical section
 */
