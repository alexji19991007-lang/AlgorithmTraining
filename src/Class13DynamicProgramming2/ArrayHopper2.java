package Class13DynamicProgramming2;

// Given an array A of non-negative integers, you are initially positioned at index 0 
// of the array. A[i] means the maximum jump distance from index i (you can only jump 
// towards the end of the array). Determine the minimum number of jumps you need to reach the end of array. If you can not reach the end of the array, return -1.

// Assumptions
// The given array is not null and has length of at least 1.

// Examples
// {3, 3, 1, 0, 4}, the minimum jumps needed is 2 (jump to index 1 then to the end of array)
// {2, 1, 1, 0, 2}, you are not able to reach the end of array, return -1 in this case.

// 1. What does dp[i] mean?
// dp[i] represents the minimum number of jumps needed to reach the last index
// starting from the current index i.
// If dp[i] = -1, it means index i cannot reach the end.

// 2. What is the base case?
// dp[n - 1] = 0
// At the last index, no jumps are needed to reach the end.

// 3. What is the recurrence relation?
// For each index i, we can jump to any index j where
// i < j <= i + array[i]
//
// dp[i] = min(dp[j] + 1) for all valid j where dp[j] != -1
//
// If none of those j can reach the end (i.e. all dp[j] == -1)
// then dp[i] = -1
public class ArrayHopper2 {
    public int minJump2(int[] array) {
        int n = array.length;
        int[] minimumJumps = new int[n];
        minimumJumps[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            int curMin = Integer.MAX_VALUE; // 比小设大，比大设小
            for (int j = i + 1; j <= Math.min(n - 1, array[i] + i); j++) {
                if (minimumJumps[j] != -1) {
                    curMin = Math.min(minimumJumps[j] + 1, curMin);
                }
            }
            minimumJumps[i] = curMin == Integer.MAX_VALUE ? -1 : curMin;
            // minimumJumps[i] = -1;
            // for (int j = i + 1; j <= Math.min(array[i] + i, n - 1); ++j) {
            //     if (minimumJumps[j] != -1 && (minimumJumps[i] == -1 || minimumJumps[i] > 1 + minimumJumps[j])) {
            //         minimumJumps[i] = minimumJumps[j] + 1;
            //     }
            // }
        }
        return minimumJumps[0];
    }
}
