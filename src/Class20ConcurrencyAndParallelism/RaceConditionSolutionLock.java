package Class20ConcurrencyAndParallelism;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RaceConditionSolutionLock {
    public static void main(String[] args) throws Exception {
        BankAccountWithLock account = new BankAccountWithLock();

        Thread t1 = new Thread(
            () -> account.withdraw(80),
            "Thread-1"
        );

        Thread t2 = new Thread(
            () -> account.withdraw(80),
            "Thread-2"
        );

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(
            "Final balance: "
            + account.getBalance()
        );
    }
}

class BankAccountWithLock {
    private int balance = 100;

    // Why use ReentrantLock?
    // Extra features:
    //  - tryLock()
    //  - fairness
    //  - interruptible locks
    //  - timeout support
    // Used more in advanced concurrent systems.
    private final Lock myLock = new ReentrantLock();

    public void withdraw(int amount) {
        myLock.lock();
        // Any code after myLock.lock() and before myLock.unlock() is called the critical section
        // Only one thread can access the critical section code at one time.
        try {
            if (balance >= amount) {
                // Simulate delay
                try {
                    Thread.sleep(100);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }

                balance -= amount;

                System.out.println(
                    Thread.currentThread().getName()
                    + " withdrew money"
                );
            }
            else {
                System.out.println(
                    Thread.currentThread().getName()
                    + " insufficient funds"
                );
            }
        }
        finally {
            myLock.unlock();
        }
    }

    public int getBalance() {
        return balance;
    }
}