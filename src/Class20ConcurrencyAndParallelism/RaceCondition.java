package Class20ConcurrencyAndParallelism;

public class RaceCondition {
    public static void main(String[] args) throws Exception {
        BankAccount account = new BankAccount();

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

        // Expected result is: "Final balance: 20"
        // But in reality it could be: "Final balance: -60"
        // The bug happens because: check + modify is not atomic.
    }
}

class BankAccount {
    private int balance = 100;

    public void withdraw(int amount) {
        if (balance >= amount) {
            System.out.println(
                Thread.currentThread().getName()
                + " is withdrawing..."
            );

            // simulate delay
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

            balance -= amount;

            System.out.println(
                Thread.currentThread().getName()
                + " completed withdrawal"
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