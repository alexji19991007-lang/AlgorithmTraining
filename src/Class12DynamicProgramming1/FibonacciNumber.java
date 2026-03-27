package Class12DynamicProgramming1;

public class FibonacciNumber {
    public long fibonacciRecursion(int k) {
        if (k <= 0) return 0;
        if (k <= 2) return 1;
        return fibonacciRecursion(k - 1) + fibonacciRecursion(k - 2);
    }

    // F(0) = 0
    // F(1) = 1
    // F(2) = 1
    // F(n) = F(n-1) + F(n-2)
    public long fibonacciDp(int k) {
        if (k <= 0) {
            return 0;
        }
        if (k <= 2) {
            return 1;
        }
        long[] fibo = new long[k + 1];
        fibo[0] = 0;
        fibo[1] = 1;
        for (int i = 2; i <= k; ++i) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }
        return fibo[k];
    }

    // We find out that fibo[i] only depends on fibo[i-1] & fibo[i-2]
    // So we don't actually need any array!
    public long fibonacciDpOptimizedForSpace(int k) {
        if (k <= 0) {
            return 0;
        }
        if (k <= 2) {
            return 1;
        }
        // a代表了(n-2)th number, b代表了(n-1)th number
        long a = 1, b = 1;
        for (int i = 3; i <= k; ++i) {
            long nextNumber = a + b;
            a = b;
            b = nextNumber;
        }
        return b;
    }
}
