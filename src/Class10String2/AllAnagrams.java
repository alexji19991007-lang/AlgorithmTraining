package Class10String2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Find all occurrence of anagrams of a given string s in a given string l. 
// Return the list of starting indices.

// Assumptions
// s is not null or empty.
// l is not null.

// Examples
// l = "abcbac", s = "ab", return [0, 3] since the substring with length 2 
// starting from index 0/3 are all anagrams of "ab" ("ab", "ba").

public class AllAnagrams {
    public List<Integer> allAnagrams(String s, String l) {
        List<Integer> res = new ArrayList<>();
        if (s.length() == 0 || s.length() > l.length()) {
            return res;
        }
        Map<Character, Integer> charCount = getCount(s);
        int matchedCount = 0;
        for (int i = 0; i < l.length(); i++) {
            char currentChar = l.charAt(i);
            // 处理fast pointer向右延伸的情况
            if (charCount.containsKey(currentChar)) {
                int count = charCount.get(currentChar);
                if (count == 1) {
                    matchedCount++;
                }
                charCount.put(currentChar, count - 1);
            }
            // 处理slow pointer向右移动的情况
            if (i > s.length() - 1) {
                char toRemove = l.charAt(i - s.length());
                if (charCount.containsKey(toRemove)) {
                    int count = charCount.get(toRemove);
                    if (count == 0) {
                        matchedCount--;
                    }
                    charCount.put(toRemove, count + 1);
                }
            }
            if (matchedCount == charCount.size()) {
                res.add(i - s.length() + 1);
            }
        }

        return res;
    }

    public Map<Character, Integer> getCount(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char cur = s.charAt(i);
            count.put(cur, count.getOrDefault(cur, 0) + 1);
        }
        return count;
    }
}
