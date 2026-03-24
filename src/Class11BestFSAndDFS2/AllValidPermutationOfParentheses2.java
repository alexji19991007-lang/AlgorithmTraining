package Class11BestFSAndDFS2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// Get all valid permutations of l pairs of (), m pairs of <> and n pairs of {}.

// Assumptions
// l, m, n >= 0
// l + m + n > 0

// Examples
// l = 1, m = 1, n = 0, all the valid permutations are ["()<>", "(<>)", "<()>", "<>()"]

// 这道题目的本质：
// DFS + 状态控制（remain + stack）
// 3个关键状态：
//      1. remain[] —— 还剩多少括号可以用: int[] remain = new int[] {l, l, m, m, n, n};
//         偶数index = 左括号，奇数index = 右括号
//      2. mStack —— 当前未匹配的左括号（核心），注意我们stack里面只放左括号
//         它保证：只能用正确顺序的右括号
//         例如：当前 stack = [ '<', '(' ] --> 你只能关 ），不能关 >
//      3. StringBuilder solution —— 当前构造的字符串

public class AllValidPermutationOfParentheses2 {
    private static final char[] PS = new char[] {'(', ')', '<', '>', '{', '}'};

    public List<String> validParentheses(int l, int m, int n) {
        int[] remain = new int[] {l, l, m, m, n, n};
        int targetLen = 2 * (l + m + n);
        StringBuilder solution = new StringBuilder();
        Deque<Character> mStack = new ArrayDeque<>();
        List<String> res = new ArrayList<>();
        helper(remain, targetLen, mStack, solution, res);
        return res;
    }

    private void helper(int[] remain, int targetLen, Deque<Character> mStack, StringBuilder solution, List<String> res) {
        if (solution.length() == targetLen) {
            res.add(solution.toString());
            return;
        }
        // for loop里面是同一层recursion tree，6叉树
        for (int i = 0; i < remain.length; i++) {
            if (i % 2 == 0) {
                // add left parenthesis
                if (remain[i] > 0) {
                    // If we still have this kind of left parenthesis left
                    // Choose
                    solution.append(PS[i]);
                    mStack.offerFirst(PS[i]);
                    remain[i]--;
                    // continue to next level of DFS
                    helper(remain, targetLen, mStack, solution, res);
                    // Unchoose
                    solution.deleteCharAt(solution.length() - 1);
                    mStack.pollFirst();
                    remain[i]++;
                }
            } else {
                // add right parenthesis
                if (!mStack.isEmpty() && mStack.peekFirst() == PS[i - 1]) {
                    // If the current right parenthesis satisfies the requirment
                    // Choose
                    solution.append(PS[i]);
                    mStack.pollFirst(); // Get rid of the paired parentheses on the stack
                    remain[i]--;
                    // continue to next level of DFS
                    helper(remain, targetLen, mStack, solution, res);
                    // Unchoose
                    solution.deleteCharAt(solution.length() - 1);
                    mStack.offerFirst(PS[i - 1]);
                    remain[i]++;
                }
            }
        }
    }
}
