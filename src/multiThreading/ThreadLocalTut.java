package multiThreading;

public class ThreadLocalTut {
    public static void main(String[] args) {
        ThreadLocal<String> name = new ThreadLocal<>();
        ThreadLocal<String> name2 = ThreadLocal.withInitial(() -> "Guest");

        Thread t1 = new Thread(() -> {
            try{
                name.set("Doremon");
                System.out.println(Thread.currentThread().getName() + " prints name: " + name.get());
            }finally {
                name.remove();
            }
        });

        Thread t2 = new Thread(() -> {
            try{
                name.set("Nobita");
                System.out.println(Thread.currentThread().getName() + " prints name: " + name.get());
            }finally {
                name.remove();
            }
        });

        t1.start();
        t2.start();
    }
}

/*
    With manual threads, when the thread dies its ThreadLocalMap is garbage collected.
    But pool threads NEVER die — they stay alive waiting for new tasks. So every ThreadLocal value set by every task
    accumulates in memory forever. Classic memory leak.

    Rule: whenever you use ThreadLocal inside an executor or thread pool, always call remove() in a finally block.
          Same pattern as lock.unlock().
 */