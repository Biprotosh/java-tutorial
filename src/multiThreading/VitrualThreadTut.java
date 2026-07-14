package multiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VitrualThreadTut {
    public static void main(String[] args) {

        // simple thread
        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        });

        t1.start(); // makes a thread in system and linked with this jvm thread with one to one mapping

        // virtual thread --> internally uses fork join pool
        Thread vt = Thread.startVirtualThread(() -> {
            System.out.println(Thread.currentThread() + " virtual thread");
        });

        // to keep main thread wait, because main thread is a system thread, so it needs to wait so that vitrual thread can run
        try{
            vt.join();
        }catch(Exception e){}

        // Preferable approach to make a virtual thread. Internally makes virtual threads inside thread pool
        try(ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()){
            for(int i = 1; i <= 5; i++){
                executor.execute(() -> {
                    System.out.println("Task executed by: " + Thread.currentThread());
                });
            }
        }
    }
}

/*
    When a virtual thread blocks (waiting for IO, sleep, lock) — the JVM unmounts it from the OS thread and parks it.
    Another virtual thread takes over the OS thread immediately. Zero OS thread wasted on waiting.
 */
