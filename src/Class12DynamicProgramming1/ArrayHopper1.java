package Class12DynamicProgramming1;

// Given an array A of non-negative integers, you are initially positioned at index 0 of the 
// array. A[i] means the maximum jump distance from that position (you can only jump towards 
// the end of the array). Determine if you are able to reach the last index.

// Assumptions
// The given array is not null and has length of at least 1.

// Examples
// {1, 3, 2, 0, 3}, we are able to reach the end of array(jump to index 1 then reach the end of the array)
// {2, 1, 1, 0, 2}, we are not able to reach the end of array
public class ArrayHopper1 {
    // 1. What does dp[i] mean?
    //      dp[i] = Whether we can reach the last index starting from index i
    //      (true means reachable, false means not reachable)
    // 2. What is the base case?
    //      dp[n - 1] = true
    //      Because if we are already at the last index, we have reached the goal
    // 3. What is the recurrence relations?
    // When we are at index i, we can jump to any position:
    //    i <= j <= i + array[i]
    //
    // So we check all possible next positions j:
    //
    //    3.1 If there exists a j such that dp[j] == true,
    //        then dp[i] = true (we can reach the end through j)
    //
    //    3.2 If none of them can reach the end,
    //        then dp[i] = false
    //
    // So:
    //
    // dp[i] = OR over all j in [i, min(i + array[i], n - 1)] of dp[j]
    //
    // i.e.
    //
    // dp[i] = true,  if there exists j such that:
    //                  i <= j <= i + array[i] AND dp[j] == true
    //         false, otherwise
    public boolean canJump(int[] array) {
        // 从后往前走
        int n = array.length;
        boolean[] jump = new boolean[n];
        jump[n - 1] = true;
        for (int i = n - 2; i >= 0; --i) {
            // array[i]是能走的距离
            // i和j都是index
            for (int j = i; j <= Math.min(array[i] + i, n - 1); ++j) {
                if (jump[j]) {
                    jump[i] = true;
                    break;
                }
            }
        }
        return jump[0];
    }
}
