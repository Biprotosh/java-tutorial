package multiThreading;

public class ExecutionOrder {
    public static void main(String[] args) {
        // t1 prints 1 to 100 only even numbers
        Thread t1 = new Thread(() -> {
            for (int i = 1; i  <=100; i++)
                if(i % 2 == 0)
                    System.out.println(i);
        });

        // t2 prints 1 to 100 only odd numbers
        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 100; i++)
                if(i % 2 != 0)
                    System.out.println(i);
        });

        t1.start();
        t2.start();
    }
}

/*
    Thread are non-deterministic in nature, we don't know which thread will run and in what order it will run
 */
