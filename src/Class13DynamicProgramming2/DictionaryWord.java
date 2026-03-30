package Class13DynamicProgramming2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Given a word and a dictionary, determine if it can be composed by concatenating words
// from the given dictionary.

// Assumptions
// The given word is not null and is not empty
// The given dictionary is not null and is not empty and all the words in the dictionary are
// not null or empty

// Examples
// Dictionary / HashSet: {“bob”, “cat”, “rob”}
// Word: “robob” return false
// Word: “robcatbob” return true since it can be composed by "rob", "cat", "bob"

// 1. What does dp[i] mean?
// dp[i] = whether the string from index 0 to index i - 1 can be broken into words from the dictionary
// If dp[i] = true, it means input[0...i-1] can be formed by concatenating words from the dictionary.

// 2. What is the base case?
// An empty string can always be broken (no words needed) --> always return true
// dp[0] = true

// 3. What is the recurrence relation?
// For each index i (1 <= i <= input.length()):
// We try all possible split points j where 0 <= j < i:
//
// If there exists any j, such that dp[j] == true (left part can be segmented) AND input.substring(j, i) is in the dictionary (right part is a valid word),
// then dp[i] = true
// dp[i] =  OR over {for all all j in [0, i): dp[j] == true && dictionary.contains(input.substring(j, i))}
// true OR false OR false => true
public class DictionaryWord {
    public boolean canBreak(String input, String[] dict) {
        Set<String> wordDict = new HashSet<>(Arrays.asList(dict));
        int n = input.length();
        boolean[] breakable = new boolean[n + 1];
        breakable[0] = true;
        for (int i = 0; i <= n; ++i) {
            // 左大段 --> 能不能break？ --> 查表
            // 右小段 --> 把右边当成一个不能break的整体 --> 直接看整个右边在不在词典里
            for (int j = 0; j <= i; ++j) {
                if (breakable[j] && wordDict.contains(input.substring(j, i))) {
                    breakable[i] = true;
                    break;
                }
            }
        }
        return breakable[breakable.length - 1];
    }
}
