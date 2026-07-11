package multiThreading.locks;

public class ClassVsObjectLock {
    public static void main(String[] args) {
        Test2 tst = new Test2();

        Thread t1 = new Thread(Test2::m1);
        Thread t2 = new Thread(tst::m2);

        t1.start();
        t2.start();
    }
}

class Test2{
    static void m1(){
        synchronized (Test2.class){
            System.out.println("M1 entered");
            try{
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("M1 exit");
        }
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
    Both the threads can enter the method almost at the same time. We have one unique lock for class and one unique lock for
    object
 */