package Class9String1;

// Remove adjacent, repeated characters in a given string, leaving no character for each group of such characters. The characters in the string are sorted in ascending order.

// Assumptions
// Try to do it in place.

// Examples
// “aaaabbbc” is changed to “c”
// "12221331" is changed to "111"
// "abbccbbcbe" is changed to "acbe"

// Corner Cases
// If the given string is null, we do not need to do anything.
public class RemoveAdjacentRepeatedCharacters3 {
    public String deDup(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        int slow = 0;
        boolean hasRepeat = false;
        for (int fast = 1; fast < array.length; ++fast) {
            if (array[fast] == array[slow]) {
                hasRepeat = true;
            } else if (hasRepeat) {
                array[slow] = array[fast];
                hasRepeat = false;
            } else {
                array[++slow] = array[fast];
            }
        }
        return new String(array, 0, hasRepeat ? slow : slow + 1);
  }
}
