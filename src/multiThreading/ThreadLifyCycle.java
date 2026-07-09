package multiThreading;

public class ThreadLifyCycle {
    public static void main(String[] args) {

        Thread mainThread = Thread.currentThread(); // reference of main thread

        // NEW stage
        Thread t1 = new Thread(() -> {
            System.out.println("Name of current thread is: " + Thread.currentThread().getName());
            System.out.println("Main thread state: " + mainThread.getState());
        });
        System.out.println(t1.getState());

        // Runnable stage
        t1.start();
        /*
            here we can get either RUNNABLE/TERMINATED, because it can happen that OS very fast creates and runs the thread,
            execute its logic and prints TERMINATED, but it has a very low chance that it prints TERMINATED.
            Mostly 100% of time it will print first the state then execute the logic of the thread
        */
        System.out.println(t1.getState()); // RUNNABLE/TERMINATED

//        System.out.println(t1.getState()); // RUNNABLE
//        System.out.println(t1.getState()); // RUNNABLE
//        System.out.println(t1.getState()); // RUNNABLE
        // every time prints RUNNABLE because getState() execute faster than executing the thread, there is a case
        // where if I write 100/200 times then maybe TERMINATED can print

        // TERMINATED stage
        try{
            // prints runnable because main thread gets to sleep in the next line
//            System.out.println(Thread.currentThread().getName() + " : " + Thread.currentThread().getState());
            Thread.sleep(2000); // pausing the main thread
        }catch (Exception e){}
        System.out.println(t1.getState());

    }
}
