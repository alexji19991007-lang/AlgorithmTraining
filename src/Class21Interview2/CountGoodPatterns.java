package Class21Interview2;

// Given an integer array nums, and two integers n and k, count how many contiguous subarrays of length n contain exactly k distinct integers.
// A subarray is a contiguous non-empty sequence of elements within an array.
// Return the total number of valid subarrays.

// Example 1
// Input:
// nums = [1, 2, 1, 2, 3]
// n = 3
// k = 2
// Output:
// 2

// Explanation 1
// All subarrays of length 3:
// [1,2,1] -> 2 distinct integers ✅
// [2,1,2] -> 2 distinct integers ✅
// [1,2,3] -> 3 distinct integers ❌
// Answer = 2

// Example 2:
// Input:
// nums = [1, 1, 2, 2, 3]
// n = 3
// k = 2
// Output:
// 3

// Explanation 2
// [1,1,2] -> 2 distinct integers ✅
// [1,2,2] -> 2 distinct integers ✅
// [2,2,3] -> 2 distinct integers ✅
// Answer = 3


// Example 3
// Input:
// nums = [4, 4, 4, 4]
// n = 3
// k = 1
// Output:
// 2

// Explanation 3
// [4,4,4] -> 1 distinct integer ✅
// [4,4,4] -> 1 distinct integer ✅
// Answer = 2

// Example 4
// Input:
// nums = [1, 2, 3, 4]
// n = 2
// k = 2
// Output:
// 3

// Explanation 4
// [1,2] -> 2 distinct integers ✅
// [2,3] -> 2 distinct integers ✅
// [3,4] -> 2 distinct integers ✅
// Answer = 3

import java.util.HashMap;
import java.util.Map;

public class CountGoodPatterns {
    public int goodPattern(int[] nums, int n, int k) {
        return -1;
    }
}
