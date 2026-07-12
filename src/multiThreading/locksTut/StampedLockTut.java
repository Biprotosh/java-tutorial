package multiThreading.locksTut;

import java.util.concurrent.locks.StampedLock;

public class StampedLockTut {
    public static void main(String[] args) {
        SharedResource1 sr = new SharedResource1();

        // readers
        Thread r1 = new Thread(sr::read);
        Thread r2 = new Thread(sr::read);
        Thread r3 = new Thread(sr::read);

        // writers
        Thread w1 = new Thread(() -> sr.write(5));
        Thread w2 = new Thread(() -> sr.write(8));
        Thread w3 = new Thread(() -> sr.write(11));

        r1.start();
        r2.start();
        r3.start();

        w1.start();
        w2.start();
        w3.start();
    }
}

class SharedResource1{
    private int val = 0;
    // locks
    StampedLock lock = new StampedLock();

    public void read(){
        long stamp = lock.tryOptimisticRead();

        int currentValue = val;

        try{
            Thread.sleep(1000);
        }catch(Exception e){}

        // validate stamp
        if(!lock.validate(stamp)){
            // fall over logic by doing pessimistic locking technique
            stamp = lock.readLock();

            try{
                currentValue = val;
            }finally {
                lock.unlockRead(stamp);
            }
        }

        System.out.println(Thread.currentThread().getName() + " reads value to " + currentValue);
    }

    public void write(int val){
        long stamp = lock.writeLock();
        try{
            try{
                Thread.sleep(1000);
            }catch(Exception e){}

            this.val = val;
            System.out.println(Thread.currentThread().getName() + " changes value to " + val);
        }finally {
            lock.unlockWrite(stamp);
        }
    }

}
