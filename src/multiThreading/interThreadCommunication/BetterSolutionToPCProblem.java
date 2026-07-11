package multiThreading.interThreadCommunication;

public class BetterSolutionToPCProblem {
    public static void main(String[] args) {
        Box2 box = new Box2();

        Thread t1 = new Thread(() -> {
            for(int i = 1; i <= 20; i++){
                try{
                    Thread.sleep(100);
                    box.producer(i);
                }catch (InterruptedException e){}
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i=1; i<=20; i++){
                try{
                    Thread.sleep(100);
                    box.consumer();
                }catch (InterruptedException e){}
            }
        });

        t1.start();
        t2.start();
    }
}

class Box2{
    volatile Integer item; // using volatile so that it fetch value from RAM not from cache memory of a thread
    volatile Boolean flag = false;

    synchronized void producer(int val) throws InterruptedException {
        while (flag == true) {  // known as guarded block, to avoid problem from spurious wakeup
            wait();
        }

        item = val;
        flag = true;

        System.out.println("Producer produces: " + item);
        notify(); // safe and preferred method notifyAll()
    }

    synchronized void consumer() throws InterruptedException {
        while (flag == false){ // known as guarded block, to avoid problem from spurious wakeup
            wait();
        }

        System.out.println("Consumer consumes: " + item);
        item = null;
        flag = false;
        notify(); // safe and preferred method notifyAll()
    }
}

/*
    notify() can make a deadlock situation, that's why notifyAll() is safer method because it wakes up all the threads
    waiting in the waiting queue.

    Spurious wakeup happens when threads from the waiting queue wakes up by itself, even if we didn't call notify/notifyAll
    method. It happens because java can't fully control threads and because of CPU/OS optimizations OS does this. And to
    avoid this phenomena we use guarded block
 */