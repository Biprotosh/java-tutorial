package multiThreading.problemsWithMultithreading;

public class RaceConditionTut {
    public static void main(String[] args) {
        Counter c1 = new Counter();

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

class Counter{
    public int cnt = 0;

    void increment(){
        cnt++; // critical section
    }
}