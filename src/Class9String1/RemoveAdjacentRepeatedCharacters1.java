package Class9String1;

// Remove adjacent, repeated characters in a given string, leaving only one character for each group of such characters.

// Assumptions
// Try to do it in place.

// Examples
// “aaaabbbc” is transferred to “abc”

// Corner Cases
// If the given string is null, returning null or an empty string are both valid.
public class RemoveAdjacentRepeatedCharacters1 {
    public String deDup(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        int slow = 1, fast = 1;
        while (fast < array.length) {
            if (array[fast] != array[slow - 1]) {
                array[slow++] = array[fast];
            }
            fast++;
        }
        
        return new String(array, 0, slow);
    }
}
