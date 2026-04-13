package Class16BitRepresentationAndOperation;

public class BitwiseOperations {
    public static void main(String[] args) {
        int a = 5;  // 0101
        int b = 3;  // 0011

        // 1. Bitwise AND (&)
        int andResult = a & b;  // 0001 = 1
        System.out.println("a & b = " + andResult);

        // 2. Bitwise OR (|)
        int orResult = a | b;   // 0111 = 7
        System.out.println("a | b = " + orResult);

        // 3. Bitwise XOR (^)
        int xorResult = a ^ b;  // 0110 = 6
        System.out.println("a ^ b = " + xorResult);

        // 4. Bitwise NOT (~)
        int notA = ~a;          // flips all bits
        // a = 5  → 00000000 00000000 00000000 00000101
        // ~a     → 11111111 11111111 11111111 11111010
        //        → -6
        System.out.println("~a = " + notA);

        // 5. Left Shift (<<)
        int leftShift = a << 1; // 1010 = 10
        // 注意！Left Shift等于给原来的数字 * 2
        System.out.println("a << 1 = " + leftShift);

        // 6. Right Shift (>>)
        int positive = 8;       // 0000...1000
        int negative = -8;      // 1111...1000
        // Right Shift 正数左侧补充零 (positive number)，负数左侧补充1
        int posRightShift = positive >> 1; // 0000...0100 = 4
        int negRightShift = negative >> 1; // 1111...1100 = -4
        // 注意！Right Shift等于给原来的数字 / 2
        System.out.println("8 >> 1 = " + posRightShift);
        System.out.println("-8 >> 1 = " + negRightShift);
    }

    // Q1. Given a number x, test whether x’s k-th bit is one. (bit tester)
    public static void TestKthBit(int x, int k) {
        // Method 1: Right Shift x by k-times, then & with 1 -- This is RECOMMENDED
        int kthBit = (x >> k) & 1;
        System.out.println("kth bit is: " + kthBit);

        // Method 2: Left Shift 1 by k-times, then & with x
        int leftShift1 = 1 << k;
        kthBit = (leftShift1 & x) > 0 ? 1 : 0;
        System.out.println("kth bit is: " + kthBit);
    }

    // Q2. Given a number x, how to set x’s k-th bit to 1? (bit setter)
    public static void SetKthBitTo1(int x, int k) {
        // Left Shift 1 by k-times, then | with x
        int leftShift1 = 1 << k;
        int afterSet = (x | leftShift1);
        System.out.println("After setting x's kth bit to 1: " + afterSet);
        // We can also write like this
        x |= (1 << k);
    }

    // Q3: Given a number x, how to set x’s k-th bit to 0? (bit resetter)
    public static void SetKthBitTo0(int x, int k) {
        // bit & 0 == 0
        // bit & 1 == bit
        // Left Shift 1 by k-times; Negate it; Then & with x
        int leftShift1 = 1 << k;
        int leftShift1Negate = ~leftShift1;
        int afterSet = (x & leftShift1Negate);
        System.out.println("After setting x's kth bit to 0: " + afterSet);
        // We can also write like this
        x &= ~(1 << k);
    }
}
