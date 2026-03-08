package Class8DFS1;

import java.util.ArrayList;
import java.util.List;

// Given N pairs of parentheses “()”, return a list with all the valid permutations.

// Assumptions
// N > 0

// Examples
// N = 1, all valid permutations are ["()"]
// N = 3, all valid permutations are ["((()))", "(()())", "(())()", "()(())", "()()()"]

// DFS 基本⽅法：
// 1. what does it store on each level? (每层代表什么意义？⼀般来讲解题之前就知道DFS要recurse多少层)
//      a. 6 levels, each level considers one position (in which there will be only one parenthesis added in this position)
// 2. How many different states should we try to put on this level? (每层有多少个状态/case 需要try)
//      a. two, either left or right parenthesis

// Restriction. whenever we insert a new “)”, we need to make sure the number of “(“ added so far 
// is larger than the number of “)” added so far.
// Example: (( --> 2 left parentheses --> we can add a right parenthesis --> (()
//          () --> 1 left parenthese + 1 right parenthesis --> we cannot add an extra right parenthesis --> ()( --> 只能加left
// We need to keep counts for the total number of ( and ) we have added so far on each level
public class AllValidPermutationsOfParentheses {
    public List<String> validParentheses(int n) {
        List<String> res = new ArrayList<>();
        char[] solution = new char[n * 2]; // 当我们明确知道最终答案的长度的时候，用char array，不用StringBuilder
        findPermutation(n, 0, 0, 0, solution, res);
        return res;
    }

    private void findPermutation(int n, int index, int leftUsed, int rightUsed, char[] solution, List<String> res) {
        if (index == 2 * n) {
            res.add(new String(solution)); // 只有leaf node才是答案
            return;
        }
        if (leftUsed < n) {
            solution[index] = '('; // select
            findPermutation(n, index + 1, leftUsed + 1, rightUsed, solution, res);
        }
        if (rightUsed < leftUsed) {
            solution[index] = ')'; // 这里直接把我们在访问left child时候加的东西给overwrite了 --> 隐形的unselect
            findPermutation(n, index + 1, leftUsed, rightUsed + 1, solution, res);
        }
    }

    // TC: O(2^(2n) * n)
    // SC: O(n)
}
