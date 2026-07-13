package multiThreading;

public class ThreadLocalTut {
    public static void main(String[] args) {
        ThreadLocal<String> name = new ThreadLocal<>();

        Thread t1 = new Thread(() -> {
            name.set("Doremon");
            System.out.println(Thread.currentThread().getName() + " prints name: " + name.get());
        });

        Thread t2 = new Thread(() -> {
            name.set("Nobita");
            System.out.println(Thread.currentThread().getName() + " prints name: " + name.get());
        });

        t1.start();
        t2.start();
    }
}
