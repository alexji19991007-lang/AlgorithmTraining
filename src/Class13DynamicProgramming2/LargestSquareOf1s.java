package Class13DynamicProgramming2;

// Determine the largest square of 1s in a binary matrix (a binary matrix only
// contains 0 and 1), return the length of the largest square.

// Assumptions
// The given matrix is not null and guaranteed to be of size N * N, N >= 0

// Examples
// { {0, 0, 0, 0},
//   {1, 1, 1, 1},
//   {0, 1, 1, 1},
//   {1, 1, 1, 1}}
// the largest square of 1s has length of 2

// 1. What does dp[i][j] mean?
// dp[i][j] (largest[i][j] in code) represents the side length of the largest square
// consisting of only 1s, with the bottom-right corner at cell (i, j).

// 2. What is the base case?
// If i == 0 or j == 0:
//   dp[i][j] = matrix[i][j]
// Because on the first row or first column, the largest square can only be
// of size 1 (if the cell is 1) or 0 (if the cell is 0).

// 3. What is the recurrence relation?
// If matrix[i][j] == 1:
//   dp[i][j] = 1 + min(
//       dp[i - 1][j],      // top
//       dp[i][j - 1],      // left
//       dp[i - 1][j - 1]   // top-left (diagonal)
//   )
//
// If matrix[i][j] == 0:
//   dp[i][j] = 0
//
// Explanation:
// To form a square ending at (i, j), the top, left, and top-left neighbors
// must all be able to form squares. The size is limited by the smallest of them.
// So we take the minimum and add 1 (for the current cell).

public class LargestSquareOf1s {
    public int largest(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] largest = new int[row][col];
        int res = 0;

        

        return -1;
    }
}
