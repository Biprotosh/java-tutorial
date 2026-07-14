package multiThreading;

import java.util.concurrent.atomic.AtomicInteger;

public class TOCTOUExample {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount(100);

        // Two threads both trying to withdraw 100
        Thread t1 = new Thread(() -> account.withdraw(100), "T1");
        Thread t2 = new Thread(() -> account.withdraw(100), "T2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final balance: " + account.getBalance());
    }
}

class BankAccount {
//    private int balance;
    private AtomicInteger balance;

    BankAccount(int balance) {
        this.balance = new AtomicInteger(balance);
    }

    public int getBalance() { return balance.get(); }

    public void withdraw(int amount) {
        // CHECK — is there enough money?
        if(amount <= 0){
            System.out.println("Withdrawal amount must be positive");
            return;
        }

//        if (balance >= amount) {
//            // ← GAP: context switch happens here
//            // T1 checked: balance=100, condition true, enters
//            // T2 checked: balance=100, condition true, enters  ← TOCTOU! (Time of check Time of use)
//
//            // USE — both threads reach here and both withdraw
//            balance -= amount;
//            System.out.println(Thread.currentThread().getName()
//                    + " withdrew " + amount
//                    + " | balance now: " + balance);
//        } else {
//            System.out.println(Thread.currentThread().getName()
//                    + " | insufficient funds");
//        }

        // Robust approach
        int current, updated;
        do {
            current = balance.get();

            // insufficient
            if (current < amount) {
                System.out.println(Thread.currentThread().getName()
                    + " | insufficient funds");
                return;
            }

            updated = current - amount;


        } while (!balance.compareAndSet(current, updated));

        System.out.println(Thread.currentThread().getName()
                + " withdrew " + amount
                + " | balance now: " + balance);
    }
}

/*
    TOCTOU includes check-then-act bugs.
    Every TOCTOU vulnerability is a race condition. Not every race condition is a TOCTOU vulnerability.

    CAS is the hardware level atomic instruction
 */