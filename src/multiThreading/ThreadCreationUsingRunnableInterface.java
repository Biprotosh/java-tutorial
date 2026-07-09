package multiThreading;

public class ThreadCreationUsingRunnableInterface {
    public static void main(String[] args) {
//        Thread t1 = new Thread(new MyRunnable());
        Thread t1 = new Thread(() -> System.out.println("Thread is running"));

        t1.start();
    }
}

// Thread using Runnable interface
class MyRunnable implements Runnable{
    @Override
    public void run(){
        System.out.println("Thread is running");
    }
}

/*
    It is a preferred way to make a Thread because we can get the advantage of multiple inheritance and reusability by
    giving the same task to multiple threads.
    Runnable is a functional interface so we can use lamda expression
 */