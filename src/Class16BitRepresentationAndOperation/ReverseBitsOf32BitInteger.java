package Class16BitRepresentationAndOperation;

// How to reverse all bits of a number?
// e.g. 0b 1010 0010 → 0b 0100 0101

public class ReverseBitsOf32BitInteger {
    public long reverseBits(long x) {
        int i = 0;
        int j = 31;
        while (i < j) {
            x = swap(x, i, j);
            i++;
            j--;
        }
        return x;
    }

    private long swap(long x, int i, int j) {
        long ithBit = (x >> i) & 1;
        long jthBit = (x >> j) & 1;
        if (ithBit == jthBit) {
            return x;
        }
        return ((1 << i) + (1 << j)) ^ x;
    }
}
