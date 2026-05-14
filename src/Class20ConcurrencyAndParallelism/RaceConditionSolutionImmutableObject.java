package Class20ConcurrencyAndParallelism;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RaceConditionSolutionImmutableObject {
    public static void main(String[] args)
        throws Exception {

        BankAccountImmutable account = new BankAccountImmutable(100);

        ExecutorService pool = Executors.newFixedThreadPool(2);

        Callable<BankAccountImmutable> task1 = () -> account.withdraw(80);
        Callable<BankAccountImmutable> task2 = () -> account.withdraw(80);

        Future<BankAccountImmutable> future1 = pool.submit(task1);
        Future<BankAccountImmutable> future2 = pool.submit(task2);

        BankAccountImmutable result1 = future1.get();
        BankAccountImmutable result2 = future2.get();

        System.out.println(
            "Original balance: "
            + account.getBalance()
        );

        System.out.println(
            "Result 1 balance: "
            + result1.getBalance()
        );

        System.out.println(
            "Result 2 balance: "
            + result2.getBalance()
        );

        pool.shutdown();
    }
}

class BankAccountImmutable {
    private final int balance;

    public BankAccountImmutable(int balance) {
        this.balance = balance;
    }

    public BankAccountImmutable withdraw(int amount) {
        if (balance < amount) {
            System.out.println(
                    Thread.currentThread().getName()
                    + " insufficient funds"
                );
            return this;
        }

        // Simulate delay
        try {
            Thread.sleep(100);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Avoid shared mutable state entirely.
        // Instead of modifying the same account object, we create a new account state

        // Why is this thread-safe?
        // Because: immutable objects cannot change
        //  - No shared mutation → no race condition.
        // This idea is huge in:
        //  * functional programming
        //  * reactive systems
        //  * distributed systems
        return new BankAccountImmutable(
            balance - amount
        );
    }

    public int getBalance() {
        return balance;
    }
}