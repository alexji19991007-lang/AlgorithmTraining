package Class11BestFSAndDFS2;

import java.util.*;

// Get all valid permutations of l pairs of (), m pairs of <> and n pairs of {},
// subject to the priority restriction: {} higher than <> higher than ().
public class AllValidPermutationsOfParentheses3 {
    private static final char[] PS = new char[] {'(', ')', '<', '>', '{', '}'};

    public List<String> validParenthesesIII(int l, int m, int n) {
        int[] remain = new int[] {l, l, m, m, n, n};
        int targetLen = 2 * l + 2 * m + 2 * n;
        StringBuilder cur = new StringBuilder();
        // We will only put left parenthesis onto the stack.
        // Also, instead of putting the real parenthesis, we will instead put the index
        // of the parenthesis on to the stack, and thus enabling us to check priority more easily.
        Deque<Integer> mStack = new ArrayDeque<>();
        List<String> res = new ArrayList<>();
        helper(remain, targetLen, mStack, cur, res);
        return res;
    }

    public void helper(int[] remain, int targetLen, Deque<Integer> mStack, StringBuilder solution, List<String> res) {
        
    }
}
