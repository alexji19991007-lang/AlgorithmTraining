package Class9String1;

// Remove adjacent, repeated characters in a given string, leaving only two characters for each
// group of such characters. The characters in the string are sorted in ascending order.

// Assumptions
// Try to do it in place.

// Examples
// “aaaabbbc” is transferred to “aabbc”

// Corner Cases
// If the given string is null, we do not need to do anything.

public class RemoveAdjacentRepeatedCharacters2 {
    public String deDup(String input) {
        if (input == null || input.length() <= 2) {
            return input;
        }
        int slow = 2;
        char[] array = input.toCharArray();
        for (int fast = 2; fast < input.length(); fast++) {
            if (array[fast] != array[slow - 2] || array[fast] != array[slow - 1]) {
                array[slow++] = array[fast];
            }
        }
        return new String(array, 0, slow);
  }
}
