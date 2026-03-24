package Class11BestFSAndDFS2;

import java.util.ArrayList;
import java.util.List;

// Get all valid ways of putting N Queens on an N * N chessboard so that no two 
// Queens threaten each other.

// Assumptions
// N > 0

// Return
// A list of ways of putting the N Queens
// Each way is represented by a list of the Queen's y index for x indices of 0 to (N - 1)

// Example
// N = 4, there are two ways of putting 4 queens:
// [1, 3, 0, 2] --> 
// the Queen on the first row is at index 1
// the Queen on the second row is at index 3
// the Queen on the third row is at index 0
// the Queen on the fourth row is at index 2.
//   0 1 2 3
// 0 X Q X X
// 1 X X X Q
// 2 Q X X X
// 3 X X Q X

// [2, 0, 3, 1] --> 
// the Queen on the first row is at index 2
// the Queen on the second row is at index 0
// the Queen on the third row is at index 3 
// the Queen on the fourth row is at index 1.
// X X Q X
// Q X X X
// X X X Q
// X Q X X
public class NQueens {
    // 正对角线↙：usedDiagonals[row + col]
    // (0,0) → 0
    // (1,1) → 2
    // (2,2) → 4
    // 同一条↙对角线，row + col 相同
    private boolean[] usedDiagonals;

    // 反对角线↘：usedRevDiagonals[col - row + n - 1]
    // (0,2) → 2 → 5
    // (1,1) → 0 → 3
    // (2,0) → -2 → 1
    // 原本是 col - row（会有负数）
    // 所以：+ (n - 1)，变成非负 index
    private boolean[] usedRevDiagonals;

    private boolean[] usedCols;

    public List<List<Integer>> nqueens(int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> solution = new ArrayList<>();
        usedCols = new boolean[n];
        usedDiagonals = new boolean[2 * n - 1];
        usedRevDiagonals = new boolean[2 * n - 1];
        queensHelper(n, 0, solution, res);
        return res;
    }

    private void queensHelper(int n, int row, List<Integer> solution, List<List<Integer>> res) {
        if (row == n) {
            res.add(new ArrayList<>(solution)); // deep clone/copy
            return;
        }
        // n叉树
        for (int i = 0; i < n; i++) {
            if (canPlaceQueen(row, i, n)) {
                // Choose
                solution.add(i);
                mark(n, row, i, true); // mark as visited 
                // Continue DFS to next level
                queensHelper(n, row + 1, solution, res);
                // Unchoose
                solution.remove(solution.size() - 1);
                mark(n, row, i, false); // mark as unvisited
            }
        }
    }

    // How to check this in O(1) time?
    private boolean canPlaceQueen(int row, int col, int n) {
        return !usedCols[col] && !usedDiagonals[row + col] && !usedRevDiagonals[col - row + n - 1];
    }

    public void mark(int n, int row, int col, boolean toWhat) {
        usedCols[col] = toWhat;
        usedDiagonals[row + col] = toWhat;
        usedRevDiagonals[col - row + n - 1] = toWhat;
    }
}
