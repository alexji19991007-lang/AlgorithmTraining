package Class16BitRepresentationAndOperation;

// Determine whether a number x is a power of 2 (x == 2^n)
// Assumption x > 0
public class PowerOfTwo {
    public boolean isPowerOfTwoByCount1s(int number) {
        int oneCount = 0;
        while (number > 0) {
            oneCount += (number & 1);
            number >>= 1; // number = number >> 1;
        }
        return oneCount == 1;
    }

    public boolean isPowerOfTwo(int number) {
        return (number & (number - 1)) == 0;
    }
}
