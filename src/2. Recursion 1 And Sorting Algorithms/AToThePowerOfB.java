// Evaluate a to the power of b, assuming both a and b are integers and b is non-negative.

// Examples
// power(2, 0) = 1
// power(2, 3) = 8
// power(0, 10) = 0
// power(-2, 5) = -32
// Corner Cases

// In this question, we assume 0^0 = 1.
// What if the result is overflowed? We can assume the result will not be overflowed when we 
// solve this problem on this online judge.

// 2^16 = 2 ^ 2^15 = 2^8 * 2^8
// 2^17 = 2^8 * 2^8 * 2
// 假设b是偶数的话，a^b = a^(b/2) * a^(b/2)
// 假设b是奇数的话，a^b = a^(b/2) * a^(b/2) * a
public class AToThePowerOfB {
    public long power(int a, int b) {
        if (b == 0) {
            return 1;
        }
        if (a == 0) {
            return 0;
        }
        if (a == 1) {
            return 1;
        }
        if (b == 1) {
            return a;
        }
        long result = power(a, b/2);
        // return b % 2 == 0 ? result * result : result * result * a;
        return result * result * (b % 2 == 0 ? 1 : a);
    }
}

// P(a, b)
//  |
// P(a, b - 1)
//  |
// P(a, b - 2)
//  |
// ...
//  |
// P(a, 0)

// Time: O(b)
// Space: O(b)

// P(a, b)
//  |
// P(a, b/2)
//  |
// P(a, b/4)
//  |
// ...
//  |
// P(a, 1)
// O(log(b)) --> there are log(b) layers/stacks of recursion
// O(log(b))