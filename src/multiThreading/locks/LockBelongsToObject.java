package multiThreading.locks;

public class LockBelongsToObject {
    public static void main(String[] args) {
        Test1 tst = new Test1();

        Thread t1 = new Thread(tst::m1);
        Thread t2 = new Thread(tst::m2);

        t1.start();
        t2.start();
    }
}

class Test1{
    synchronized void m1(){
        System.out.println("M1 entered");
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("M1 exit");
    }

    synchronized void m2(){
        System.out.println("M2 entered");
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("M2 exit");
    }
}

/*
    Even if both the threads call different methods, the thread t1/t2 which acquire the lock of tst object, fist complete the task
    then another thread can enter the lock. It happens because every Object in java have a internal lock and the thread
    which enters the critical section first, acquires the internal lock of that object.
    One object has only one lock
 */
