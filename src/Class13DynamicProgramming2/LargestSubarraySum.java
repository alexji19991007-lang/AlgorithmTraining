package Class13DynamicProgramming2;

// Given an unsorted integer array, find the subarray that has the greatest sum. Return the sum.

// Assumptions
// The given array is not null and has length of at least 1.

// Examples
// {2, -1, -2, 2, 1}, the largest subarray sum is 2 + (-1) + 4 = 5
// {-2, -1, -3}, the largest subarray sum is -1
public class LargestSubarraySum {
    public int largestSum(int[] array) {
        int prevSum = array[0];
        int globalMax = array[0];
        for (int i = 1; i < array.length; ++i) {
            // Discard prevSum and start over again if prevSum becomes negative
            // Why is starting over always better?
            // Two cases:
            //      1. If the current number is positive: It is better with itself (i.e without the prevSum).
            //      2. If the current number is negative: With a negative prevSum, it will only be more negative.
            prevSum = Math.max(prevSum + array[i], array[i]);
            globalMax = Math.max(prevSum, globalMax);
        }
        return globalMax;
    }
}
