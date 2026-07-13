package multiThreading.executerCollectionFramework;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureAncCallable {
    public static void main(String[] args) {
        ExecutorService executer = Executors.newFixedThreadPool(2);

        Future<Integer> f1 = executer.submit(() -> {
            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){}

            return 10;
        });

        try{
            System.out.println(f1.get());
        }catch (InterruptedException | ExecutionException e){}

        executer.shutdown();
    }
}

/*
    Difference between executer.execute() and executer.submit()
    execute() expects a runnable as a parameter and submit() expects a callable parameter. 4

    runnable doesn't return anything and exception is lost means we cant catch it if there is any,
    we can catch it using ThreadFactory class

    but callable returns a value and exception is not lost, we can catch it.

    Future<V> is used to store the value in future returned by submit()
    We cant use Integer because then it will be a synchronus code. Integer i expects a value immediatly but submit() gets the
    value when a thread fully executed the task.
    And f1.get() is a special method because get() keeps the main thread waiting till the value is fetched then resumes the
    main thread.

    shutdown() tells I don't expect any more new task and waits for the current threads which are executing a task
    and then shutdowns the thread pool

    shutdownNow() tells I don't expect any more new task and also terminates the current tasks. But it is not a gurrenty
    because java can't fully control threads. We are basically requesting to OS

    invokAll(List<Callable>) takes list of callables and invoks it
    invokAny() also takes a list of callables and invoks any one task amongst them
 */