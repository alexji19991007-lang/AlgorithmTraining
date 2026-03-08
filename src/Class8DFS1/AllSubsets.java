package Class8DFS1;

import java.util.ArrayList;
import java.util.List;

// DFS经典例题1: Print all subsets of a set S = {‘a’, ‘b’, ‘c’}
// Given a set of characters represented by a String, return a list containing all subsets of the characters.

// Assumptions
// There are no duplicate characters in the original set.

// ​Examples
// Set = "abc", all the subsets are [“”, “a”, “ab”, “abc”, “ac”, “b”, “bc”, “c”]
// Set = "", all the subsets are [""]
// Set = null, all the subsets are []

// DFS 基本⽅法：
// 1. what does it store on each level? (每层代表什么意义？⼀般来讲解题之前就知道DFS要recurse多少层)
//      a. 4 levels. Between each level, it makes the decision on whether to put this element into the final set.
// 2. How many different states should we try on each node? (每个结点有多少个状态/case 需要try?)
//      a. two, each state (case) considers either select or not select
//                               {}                                     empty state
//                     /                     \                          decide for a -- index 0
//                  {a}                       {}                        state after making decision for a
//                /     \                   /     \                     decide for b -- index 1
//           {a,b}      {a}               {b}       {}                  state after making decision for b
//          /     \    /   \            /    \     /  \                 decide for c -- index 2
//       {a,b,c} {a,b} {a,c} {a}      {b,c}  {b} {c}  {}                state after making decision for c
//
// 注意！在try同一层的不同node的时候，需要先返回parent node，restore the state，然后才能try同一层的另一个node。
// Example: 假设我们在看{a,b,c}，我们需要先回到上一层，把c去掉，restore成{a,b}， 然后才能看同一层的另一个node {a, b} (没有加c的结果)
public class AllSubsets {
    public List<String> subSets(String set) {
        List<String> res = new ArrayList<>();
        if (set == null) {
            return res;
        }
        StringBuilder solution = new StringBuilder();
        findSubsets(set, 0, solution, res);
        return res;
    }

    private void findSubsets(String set, int index, StringBuilder solution, List<String> res) {
        if (index == set.length()) {
            res.add(solution.toString()); // 只有leaf node才是答案
            return;
        }
        solution.append(set.charAt(index)); // Select the current character
        findSubsets(set, index + 1, solution, res); // Go to next level (on the left)
        solution.deleteCharAt(solution.length() - 1); // Un-select the current character --> backtrack!!
        findSubsets(set, index + 1, solution, res); // Go to next level (on the right)
    }
}
// 一共有2^(n+1) - 1个node --> 2^n
// Time Complexity: O(2^n * n + 2^n) --> O(2^n * n)
// Space Complexity: O(n)
