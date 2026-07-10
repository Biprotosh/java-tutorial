package multiThreading;

public class ImportantMethods {
    public static void main(String[] args) {
        // --------------sleep()--------------
//        System.out.println("Main thread start");
//
//        try{
//            Thread.sleep(2000);
//        }catch (InterruptedException e) {}
//
//        System.out.println("Main thread ends");


        // --------------join()--------------
//        System.out.println("Main thread start");
//
//        Thread t1 = new Thread(() -> {
//            try{
//                Thread.sleep(2000);
//            }catch (InterruptedException e) {}
//            System.out.println("Thread-0 started");
//        });
//
//        t1.start();
//
//        try{
////            t1.join(); // let t1 execute first.
//            t1.join(1500); // only execute t1 for 1500 milliseconds
//        }catch (InterruptedException e) {}
//
//        System.out.println("Main thread ends");


        // --------------yield()--------------
//        Thread t1 = new Thread(() -> {
//           for (int i = 1; i <= 10; i++){
//               System.out.println("T1: " + i);
//                Thread.yield(); // it is just a request to OS and OS can reject it
//           }
//        });
//
//        Thread t2 = new Thread(() -> {
//            for (int i = 1; i <= 10; i++)
//                System.out.println("T2: " + i);
//        });
//
//        t1.start();
//        t2.start();


        // --------------interrupt()--------------
//        Thread t1 = new Thread(() -> {
////           while (true){
////               System.out.println("running");
////           }
//
//            while (!Thread.currentThread().isInterrupted()){
//                System.out.println("running");
//            }
//        });
//
//        t1.start();
//        try{
//            Thread.sleep(1);
//        } catch (InterruptedException e) {}
//        t1.interrupt();


        // --------------isAlive()--------------
//        Thread t1 = new Thread(() -> {
//            try{
//                Thread.sleep(2000); // sleep the t1 thread
//            }catch (InterruptedException e) {}
//        });
//
//        System.out.println(t1.isAlive()); // false
//        t1.start();
//        System.out.println(t1.isAlive()); // true
//
//        try{
//            Thread.sleep(3000);
//        }catch (InterruptedException e) {}
//        System.out.println(t1.isAlive()); // false


        // --------------currentThread()--------------
//        Thread t1 = new Thread(() -> {
//            System.out.println(Thread.currentThread().getName());
//        });
//
//        t1.setName("worker-1");
//        t1.start();


        // --------------getPriority()--------------
//        Thread t1 = new Thread(() -> {
//            System.out.println("Custom thread-1");
//        });
//
//        Thread t2 = new Thread(() -> {
//            System.out.println("Custom thread-2");
//        });
//
//        t1.start();
//        t2.start();
//        t1.setPriority(10);
//        System.out.println(t1.getPriority());


        // --------------Daemon Thread--------------
        Thread t1 = new Thread(() -> {
            while (true){
                System.out.println("running");
            }
        });

        t1.setDaemon(true); // when main thread terminated, stop t1 thread as well
        t1.start(); // here we created a daemon thread, because main thread is terminated

        try{
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

/*
    1. Thread.sleep(milliseconds)
    -> move the thread into TIMED_WAITING state
    RUNNABLE -> TIMED_WAITING -> TIMED_WAITING
    When a thread is in TIMED_WAITING state, it doesn't release the locks

    2. t1.join()
    -> Let the thread first complete its execution. after seeing t1.join
    Main thread -> WAITING
    t1 -> RUNNABLE -> TERMINATED
    Main -> RUNNABLE -> TERMINATED
    t1.join(milliseconds) -> gives a specific time to execute t1

    3. Thread.yield()
    -> I am willing to give my CPU time to someone else with the same priority that is ready to run.
    We don't use in production as it is just a request to OS and OS can reject it
    The current thread doesn't go to WAITING, TIMED_WAITING OR BLOCKED state, it only goes to RUNNABLE state.
    By-default the priority of the threads created in java is same

    4. t1.interrupt()
    -> Sends a singal to t1 thread that it should stop doing whatever it is doing.
    Every thread have a flag called interrupt which is by-default false and by calling interrup() method
    we just set the flag to true. It means we are just signaling the thread. interrupt is different from stop.
    here we are not forcing the thread to get stop, but in stop we are forcing the thread to stop whatever it is doing.
    We can gracefully handle the thread. I can run a thread until a condition, cancelling a long-running task and used to
    stop Thread Pool.
    isInterrupted() -> returns interrupt flag value (T/F)
    interrupted() -> returns interrupt flag value (T/F) and also set the flag to false

    5. isAlive()
    -> A thread is alive from start to till it is terminated

    6. currentThread()
    -> Gives the reference of the current running thread

    7. getPriority()
    -> In java we have 3 priorities MAX_PRIORITY = 10,  MIN_PRIORITY = 10 and  NORM_PRIORITY = 5
    Every thread we create in java have the same priority 5. Priority just tells the OS which thread is more importent.
    It depends on the OS which thread to run, we can just give the OS our suggestion. We don't usually use it in production

    8. Daemon threads
    -> Background running threads are known as daemon threads. Java divided threads into two types
    one is user threads and daemon threads. Stops immediatly once main thread is completed.
    Garbage collection runs in daemon thread
 */