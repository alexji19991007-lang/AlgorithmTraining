package Class20ConcurrencyAndParallelism;

public class RaceConditionSolutionSynchronized {
    public static void main(String[] args) throws Exception {
        BankAccountSynchronized account = new BankAccountSynchronized();

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

class BankAccountSynchronized {
    private int balance = 100;

    // What happens when we use synchronized key word?
    // Only one thread can execute withdraw() at a time.
    // So: check balance + deduct money becomes atomic.
    public synchronized void withdraw(int amount) {
        // The whole withdraw() method is the critical section defined by the synchronized keyword
        if (balance >= amount) {

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

    public int getBalance() {
        return balance;
    }
}