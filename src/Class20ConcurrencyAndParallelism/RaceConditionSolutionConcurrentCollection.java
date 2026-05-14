package Class20ConcurrencyAndParallelism;

import java.util.concurrent.CopyOnWriteArrayList;

public class RaceConditionSolutionConcurrentCollection {
    public static void main(String[] args) throws Exception {

        BankAccountWithConcurrentCollection account = new BankAccountWithConcurrentCollection(100);

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
            "Final balance = "
            + account.getBalance()
        );
    }
}

class BankAccountWithConcurrentCollection {
    // Using a concurrent collection
    // to store ONE balance value
    private final CopyOnWriteArrayList<Integer> balance = new CopyOnWriteArrayList<>();

    public BankAccountWithConcurrentCollection(int initialBalance) {
        balance.add(initialBalance);
    }

    public void withdraw(int amount) {
        int currentBalance = balance.get(0);
        if (currentBalance >= amount) {
            // Simulate delay
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            int newBalance = currentBalance - amount;
            balance.set(0, newBalance);

            System.out.println(
                Thread.currentThread().getName()
                + " withdrew "
                + amount
                + ", remaining = "
                + newBalance
            );
        }
        else {
            // Notice even tho the concurrent collection is used, we can still only guarantee
            // that individual collection operations are thread-safe.
            // But multiple operations together are not atomic still
            System.out.println(
                Thread.currentThread().getName()
                + " insufficient funds"
            );
        }
    }

    public int getBalance() {
        return balance.get(0);
    }
}