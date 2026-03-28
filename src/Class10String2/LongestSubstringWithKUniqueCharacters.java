package Class10String2;

import java.util.HashMap;
import java.util.Map;

// Given a string, get longest substring T that contains at most k distinct characters.

// Example:
// input = “eceba” and k = 2 --> result = "ece"
// input "dddabaaebacbcc" and k = 4 --> result = "abaaebacbcc"

public class LongestSubstringWithKUniqueCharacters {
    public static String longest(String input, int k) {
        char[] array = input.toCharArray();
        int slow = 0, fast = 0;
        int maxSize = 0, maxSizeStart = 0;
        Map<Character, Integer> count = new HashMap<>();
        int numUnique = 0;
        while (fast < array.length) {
            char cur = array[fast];
            int origCount = count.getOrDefault(cur, 0);
            if (origCount == 0) {
                numUnique++;
            }
            count.put(cur, origCount + 1);
            while (numUnique > k) {
                char leftmost = array[slow];
                origCount = count.get(leftmost);
                if (origCount == 1) {
                    numUnique--;
                }
                count.put(leftmost, origCount - 1);
                slow++;
            }
            if (fast - slow + 1 > maxSize) {
                maxSize = fast - slow + 1;
                maxSizeStart = slow;
            }
            fast++;
        }
        return new String(array, maxSizeStart, maxSize);
    }
}
