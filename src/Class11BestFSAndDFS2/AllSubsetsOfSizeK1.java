package Class11BestFSAndDFS2;

import java.util.ArrayList;
import java.util.List;

// Given a set of characters represented by a String, return a list
// containing all subsets of the characters whose size is K.

// Assumptions
// There are no duplicate characters in the original set.

// ​Examples
// Set = "abc", K = 2, all the subsets are [“ab”, “ac”, “bc”].
// Set = "", K = 0, all the subsets are [""].
// Set = "", K = 1, all the subsets are [].

public class AllSubsetsOfSizeK1 {
    public List<String> subSetsOfSizeK(String set, int k) {
        List<String> res = new ArrayList<>();
        if (set == null) {
            return res;
        }
        StringBuilder solution = new StringBuilder();
        findSubsets(set, k, 0, solution, res);
        return res;
    }

    private void findSubsets(String set, int k, int index, StringBuilder solution, List<String> res) {
        if (solution.length() == k) {
            res.add(solution.toString());
            // 我们不继续往下recursion了，因为再往下加东西也不符合规则了。This is called PRUNING -> 剪枝。
            return;
        }
        if (index == set.length()) {
            return;
        }
        solution.append(set.charAt(index)); // Select the current character
        findSubsets(set, k, index + 1, solution, res); // Go to next level (on the left)
        solution.deleteCharAt(solution.length() - 1); // Un-select the current character --> backtrack!!
        findSubsets(set, k, index + 1, solution, res); // Go to next level (on the right)
    }
}
