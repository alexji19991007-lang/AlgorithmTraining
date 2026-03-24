package Class11BestFSAndDFS2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Given a set of characters represented by a String, return a list containing all subsets of the characters whose size is K.
// Notice that each subset returned will be sorted for deduplication.

// Assumptions
// There could be duplicate characters in the original set.

// Examples
// Set = "abc", K = 2, all the subsets are [“ab”, “ac”, “bc”].
// Set = "abb", K = 2, all the subsets are [“ab”, “bb”].
// Set = "abab", K = 2, all the subsets are [“aa”, “ab”, “bb”].
// Set = "", K = 0, all the subsets are [""].
// Set = "", K = 1, all the subsets are [].
// Set = null, K = 0, all the subsets are [].

public class AllSubsetsOfSizeK2 {
    public List<String> subSetsIIOfSizeK(String set, int k) {
        List<String> res = new ArrayList<>();
        if (set == null) {
            return res;
        }
        if (set == "" && k > 0) {
            res.add("");
            return res;
        }
        char[] array = set.toCharArray();
        Arrays.sort(array);
        helper(array, k, 0, new StringBuilder(), res);
        return res;
    }

    private void helper(char[] array, int k, int index, StringBuilder solution, List<String> res) {
        if (solution.length() == k) {
            res.add(solution.toString());
            return;
        }
        if (index == array.length) {
            res.add(solution.toString());
            return;
        }
        // Case 1: choose array[index].
        solution.append(array[index]);
        helper(array, k, index + 1, solution, res);
        solution.deleteCharAt(solution.length() - 1);
        // If you do not choose the current letter, then skip all such letters
        // For example: a (index 0), a (index 1), b (index 2)
        // If you don't choose a at index 0, you must directly jump to b at index 2
        // This is to avoid generating duplicate subsets
        while (index < array.length - 1 && array[index] == array[index + 1]) {
            index++;
        }
        // Case 2: not choose array[index].
        helper(array, k, index + 1, solution, res);
    }
}
