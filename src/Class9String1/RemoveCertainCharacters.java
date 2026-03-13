package Class9String1;

import java.util.HashSet;
import java.util.Set;

// Remove given characters in input string, the relative order of other characters should be remained. 
// Return the new string after deletion.

// Assumptions
// The given input string is not null.
// The characters to be removed is given by another string, it is guaranteed to be not null.

// Examples
// input = "abcd", t = "ab", delete all instances of 'a' and 'b', the result is "cd".

public class RemoveCertainCharacters {
    public String remove(String input, String t) {
        char[] array = input.toCharArray();
        Set<Character> target = new HashSet<>();
        for (int i = 0; i < t.length(); ++i) {
            target.add(t.charAt(i));
        }
        int slow = 0;
        int fast = 0;
        while (fast < array.length) {
            if (!target.contains(array[fast])) {
                array[slow] = array[fast];
                slow++;
            }
            fast++;
        }
        return new String(array, 0, slow); // slow是最终的长度
    }
}
