package Class10String2;

import java.util.HashSet;
import java.util.Set;

// Given a string, find the longest substring without any repeating characters and 
// return the length of it. The input string is guaranteed to be not null.

// Example:
// For "bcdfbd", the longest substring without repeating letters for is "bcdf", 
// we should return 4 in this case.

public class LongestSubstringWithoutRepeatingCharacters {
    public int longest(String input) {
        int n = input.length();
        if (n <= 1) {
            return n;
        }
        int globalMax = 0;
        int curLen = 0;
        Set<Character> occur = new HashSet<>();
        int slow = 0;
        int fast = 0;
        while (fast < n) {
            char currentChar = input.charAt(fast);
            if (!occur.contains(currentChar)) {
                occur.add(currentChar);
                fast++;
                curLen++;
                globalMax = Math.max(globalMax, curLen);
            } else {
                occur.remove(input.charAt(slow++));
                curLen--;
            }
        }
        return globalMax;
    }
}
