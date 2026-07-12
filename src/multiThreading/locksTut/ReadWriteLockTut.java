package multiThreading.locksTut;

import java.util.concurrent.locks.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTut {
    public static void main(String[] args) {
        SharedResource sr = new SharedResource();

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

class SharedResource{
    private int val = 0;
    // locks
    ReadWriteLock rwLock = new ReentrantReadWriteLock();
    Lock rl = rwLock.readLock(); // shared lock
    Lock wl = rwLock.writeLock(); // exclusive lock


    public int read(){
        rl.lock();
        try{
            try{
                Thread.sleep(1000);
            }catch(Exception e){}

            System.out.println("Reads value as: " + val);
            return val; // even if it returns, finally will execute
        }finally {
            rl.unlock();
        }
    }

    public void write(int val){
        wl.lock();
        try{
            try{
                Thread.sleep(1000);
            }catch(Exception e){}

            this.val = val;
            System.out.println(Thread.currentThread().getName() + " changes value to " + val);
        }finally {
            wl.unlock();
        }
    }
}