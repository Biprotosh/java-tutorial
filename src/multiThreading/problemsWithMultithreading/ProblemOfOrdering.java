package multiThreading.problemsWithMultithreading;

public class ProblemOfOrdering {
    public static void main(String[] args) {
        Box b = new Box();

        Thread t1 = new Thread(() -> {
            b.set(10);
        });

        Thread t2 = new Thread(() -> {
            b.get();
        });

        t1.start();
        t2.start();
    }
}

class Box{
    int x = 0;
    boolean flag = false;

    public void set(int val){
        x = val;
        flag = true;
        System.out.println(Thread.currentThread().getName() + " sets value: " + x);
    }

    public void get(){
        if(flag){
            System.out.println(Thread.currentThread().getName() + " gets value: " + x);
        }
    }
}

/*
    In the set() method OS can first set flag = true then set x = val for CPU optimization so that CPU can execute instruction
    efficiently.

    Problem 1:
        Compiler reordering -> The Java compiler may reorder your instructions if it thinks it's faster.
                               It sees no dependency between x and flag — so it might flip them.
    Problem 2:
        CPU reordering -> Modern CPUs execute instructions out of order internally. Your CPU may write flag before x
                          reaches main memory — even if your code says otherwise.

    Problem 3:
        CPU cache visibility -> Each CPU core has its own cache. T1 writes x=10 to its cache.
                                T2 runs on a different core — and reads x from ITS cache, which still shows x=0.

    The lock ensures mutual exclusion (one thread at a time).
 */

/*
 * ============================================================
 * MEMORY BARRIER — QUICK REFERENCE NOTE
 * ============================================================
 *
 * volatile variable = a memory barrier checkpoint.
 * The JVM uses two types of barriers:
 *
 * 1. STORE BARRIER (volatile WRITE)
 *    - Triggered when you WRITE a volatile variable.
 *    - Flushes ALL variables written ABOVE it to RAM.
 *    - Guarantees: other threads see fresh values after this point.
 *
 *    Example:
 *        x = 10;          // regular write — queued in cache
 *        flag = true;     // volatile write → STORE BARRIER fires
 *                         // x and flag both flushed to RAM
 *
 * 2. LOAD BARRIER (volatile READ)
 *    - Triggered when you READ a volatile variable.
 *    - Forces ALL variables read BELOW it to come from RAM (not cache).
 *    - Guarantees: you always see the most recent value.
 *
 *    Example:
 *        if (flag) {      // volatile read → LOAD BARRIER fires
 *            use(x);      // x read fresh from RAM, not stale cache
 *        }
 *
 * KEY RULES:
 *    - Declaration order of variables = does NOT matter.
 *    - Write order inside the method = DOES matter.
 *    - STORE barrier looks BACKWARDS  (covers what's above it).
 *    - LOAD  barrier looks FORWARDS   (covers what's below it).
 *    - For reference variables: the ADDRESS is flushed, not the
 *      object's internal fields like a.getAge() etc. Use final fields or a Lock
 *      to safely share mutable objects.
 *
 * WHAT volatile SOLVES vs WHAT IT DOESN'T:
 *    Solves  → visibility (stale cache reads)
 *    Solves  → ordering  (instruction reordering)
 *    Does NOT solve → atomicity (use Lock or synchronized for that)
 * ============================================================
 */