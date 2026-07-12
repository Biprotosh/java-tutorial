package multiThreading.locksTut;

public class StaticSynchronization {
    public static void main(String[] args) {

        Thread t1 = new Thread(Counter::increment);

        Thread t2 = new Thread(Counter::increment);

        t1.start();
        t2.start();
    }
}

class Counter{
    static int cnt = 0;

//    synchronized static void increment(){
//        try{
//            Thread.sleep(2000);
//        }catch (InterruptedException e){}
//        cnt++;
//        System.out.println(cnt);
//    }

    // the above code is equivalent as this code
    static void increment(){
        synchronized (Counter.class){
            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){}
            cnt++;
            System.out.println(cnt);
        }
    }
}

/*
    synchronized static -> Here we know static method doesn't belong to a object, it belongs to a class. So here the object
    isn't locked actually the class is locked. We can lock not only an object but a class also
 */