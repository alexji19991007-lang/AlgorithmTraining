package Classs14DynamicProgramming3;


// Given a matrix that contains integers, find the submatrix with the largest sum.
// Return the sum of the submatrix.

// Assumptions
// The given matrix is not null and has size of M * N, where M >= 1 and N >= 1

// Examples
// { {1, -2, -1, 4},
//   {1, -1,  1, 1},
//   {0, -1, -1, 1},
//   {0,  0,  1, 1} }
// the largest submatrix sum is (-1) + 4 + 1 + 1 + (-1) + 1 + 1 + 1 = 7.

public class LargestSubmatrixSum {
    public int largest(int[][] matrix) {
        int R = matrix.length, C = matrix[0].length;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < R; ++i) {
            int[] cur = new int[C];
            for (int j = i; j < R; ++j) {
                // Do prefix sum for rows
                add(cur, matrix[j]);
                res = Math.max(res, largestSubarraySum(cur));
            }
        }
        return res;
    }

    // 把整个array拍扁然后做一个一维的Largest Subarray Sum
    private void add(int[] cur, int[] toAdd) {
        // Add each column with previous sum of that column
        for (int i = 0; i < cur.length; ++i) {
            cur[i] += toAdd[i];
        }
    }

    private int largestSubarraySum(int[] array) {
        int globalMax = array[0];
        int prevSum = array[0]; // 以当前位置 i 结尾的最大子数组和
        for (int i = 1; i < array.length; ++i) {
            prevSum = Math.max(prevSum + array[i], array[i]);
            globalMax = Math.max(globalMax, prevSum);
        }
        return globalMax;
    }
}
