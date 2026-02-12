// Calculate the factorial of n using recursion.

// Assumption: n >= 1.

// Example:
// n = 1 ⇒ return 1
// n = 3 ⇒ return 6
// n = 5 ⇒ return 120


public class Factorial {
    public static void main(String[] args) {
        long result = factorial(4);
        System.out.println(result);
    }

    public static long factorial(int n) {
        if (n < 1) {
            return -1;
        } // 一定要和面试官说清楚这种edge case的处理方式
        if (n == 1) {
            return 1;
        }
        long result = n * factorial(n - 1); // 每层创建了一个新的long，是O(1)，一共有n层在直上直下的path
        return result;
    }
}

// F(4)
//  |
// F(3)
//  |
// F(2)
//  |
// F(1)
// Time: O(n)
// Space: O(n)