package Class20ConcurrencyAndParallelism;

import java.util.concurrent.atomic.AtomicInteger;

public class RaceConditionSolutionAtomicInteger {
    public static void main(String[] args) throws Exception {
        BankAccountAtomicInteger account = new BankAccountAtomicInteger();

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

class BankAccountAtomicInteger {
    private final AtomicInteger balance = new AtomicInteger(100);

    public void withdraw(int amount) {
        // Why do we need this while (true)?
        // This is because compareAndSet() can fail when another thread changes the value concurrently.
        // This pattern is called: CAS (compare-and-swap) retry loop

        // 假设balance = 100, Thread A和B同时想要withdraw 80
        // 1. Thread A reads current = 100
        // 2. Thread A calculates newBalance = 20
        // 3. Before A makes the update, thread B starts running
        // 4. Thread B also reads current = 100
        // 5. Thread B also calculates newBalance = 20
        // 6. Thread B successfully updates balance to 20 using compareAndSet(100, 20)
        // 7. Now Thread A continues, it tries compareAndSet(100, 20). It will fail because
        //    the balance is already 20!! So CAS fails.
        //    If no retry -- this becomes a silent fail, but we want the insufficient funds message!
        // 8. Therefore, we must retry: 
        //    8.1 A re-reads latest balance
        //    8.2 A recalculates
        //    8.3 A retry CAS
        // 9. Prints the insufficient funds message
        while (true) {
            int current = balance.get();
            if (current < amount) {
                System.out.println(
                    Thread.currentThread().getName()
                    + " insufficient funds"
                );

                return;
            }
            int newBalance = current - amount;

            // Simulate delay
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

            // What is compareAndSet()?
            // It means: Only update the value if nobody changed it meanwhile.
            // This is:
            // lock-free concurrency
            // Very important in high-performance systems.
            boolean success = balance.compareAndSet(current, newBalance);
            if (success) {
                System.out.println(
                    Thread.currentThread().getName()
                    + " withdrew money"
                );

                return;
            }
        }
    }

    public int getBalance() {
        return balance.get();
    }
}