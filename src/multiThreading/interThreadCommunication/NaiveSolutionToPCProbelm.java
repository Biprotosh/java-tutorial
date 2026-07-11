package multiThreading.interThreadCommunication;

public class NaiveSolutionToPCProbelm {
    public static void main(String[] args) {
        Box1 box = new Box1();

        Thread t1 = new Thread(() -> {
            for(int i = 1; i <= 20; i++){
                try{
                    Thread.sleep(100);
                }catch (InterruptedException e){}
                box.producer(i);
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i=1; i<=20; i++){
                try{
                    Thread.sleep(70);
                }catch (InterruptedException e){}
                box.consumer();
            }
        });

        t1.start();
        t2.start();
    }
}

class Box1{
    volatile Integer item; // using volatile so that it fetch value from RAM not from cache memory of a thread
    volatile Boolean flag = false;

    synchronized void producer(int val){
        while (flag == true) {} // do nothing if item is there

        item = val;
        flag = true;

        System.out.println("Producer produces: " + item);
    }

    synchronized void consumer(){
        while (flag == false){} // do nothing if there is no item

        System.out.println("Consumer consumes: " + item);
        item = null;
        flag = false;
    }
}

/*
    In this Busy waiting approach race condition can occur due to non-atomic operations in both the methods. And we know
    race condition can be solved by using synchronized but if we use it then deadlock will occur. Like if first producer
    executes then it will execute perfectly but if somehow consumers execute first then t2 will acquire the lock and flag value
    is false at the fist so consumer will be stuck in a infinite loop and as it is an infinite loop t2 won't able to release
    its lock because of the loop.
 */
