package multiThreading.locksTut;

public class CustomLockObject {
    public static void main(String[] args) {
        Bank b = new Bank();

//        Thread t1 = new Thread(b::deposit);
//        Thread t2 = new Thread(b::withdraw);

        Thread t1 = new Thread(b::m1);
        Thread t2 = new Thread(b::m1);

        t1.start();
        t2.start();
    }
}

class Bank{
    // Custome locks
    Object lock1 = new Object();
    Object lock2 = new Object();

    void deposit(){
        synchronized (lock1){
            System.out.println("Deposit logic starts");
            try {
                Thread.sleep(2000);
            }catch (InterruptedException e) {}
            System.out.println("Deposit logic ends");
        }
    }

    void withdraw(){
        synchronized (lock2){
            System.out.println("Withdraw logic starts");
            try {
                Thread.sleep(2000);
            }catch (InterruptedException e) {}
            System.out.println("Withdraw logic ends");
        }
    }

    void m1(){
        /*
            There is no point of using synchronized because when ever a thread come it will create a new object
            to the heap, basically using this code we have just withdrawn the functionality of synchronized
         */
        synchronized (new Object()){
            System.out.println(Thread.currentThread().getName() + " entered m1");
            try {
                Thread.sleep(2000);
            }catch (InterruptedException e) {}
            System.out.println(Thread.currentThread().getName() + " exiting m1");
        }
    }
}

/*
    We know one object has only one lock but with this we can have a problem, where if t1/t2 enters the lock only one of them
    can execute deposite/withdraw logic at a time and other thread need to wait to finish the task of the first thread which
    entered the lock first.

    To overcome this issue we can use something called custome locks. Using this method multiple methods we can run parallely.
    Here 2 threads can execute deposite and withdraw parallely but suppse thread 1 acquires lock1's lock and thread 2 acquires
    lock2's lock then other threads can't acquire these lock until the locks released by thread 1 and 2 voluntarily.
    We know any of the two threads can execute out of order, it may happen that thread t1 execute first or t2 execute first
 */
