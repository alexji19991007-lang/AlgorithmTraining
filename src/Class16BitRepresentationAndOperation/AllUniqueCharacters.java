package Class16BitRepresentationAndOperation;

// Determine whether a string contains unique characters (i.e. no duplication).
// Assumption: all characters are ASCII characters
public class AllUniqueCharacters {
    public static boolean allUniqueCharacters(String word) {
        if (word.length() <= 1) {
            return true;
        }
        // Each int has 32 bits
        // 8 × 32 = 256 bits total
        // Enough to cover all ASCII characters --> So dic is basically a bitset
        // char cur = word.charAt(i);
        // int row = cur / 32; row → which integer in the array
        // int col = cur % 32; col → which bit inside that integer
        int[] myHashSet = new int[8];
        for (int i = 0; i < word.length(); ++i) {
            char cur = word.charAt(i);
            int row = cur / 32;
            int col = cur % 32;
            if (((myHashSet[row] >> col) & 1) == 1) {
                return false;
            }
            myHashSet[row] |= (1 << col);
        }
        return true;
    }
}
