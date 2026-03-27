package Class12DynamicProgramming1;

// Given an unsorted array, find the length of the longest subarray in which the 
// numbers are in ascending order.

// Assumptions
// The given array is not null

// Examples
// {7, 2, 3, 1, 5, 8, 9, 6}, longest ascending subarray is {1, 5, 8, 9}, length is 4.
// {1, 2, 3, 3, 4, 4, 5}, longest ascending subarray is {1, 2, 3}, length is 3.

// 1. What does dp[i] mean?
//      dp[i] = The longest ascending subarray that ends with the element at index i.
// 2. What is the base case?
//      dp[0] = 1, because when you only have 1 element, the longest ascending subarray's length is 1.
// 3. what is the recurrence relations?
//      3.1 array[i] > array[i - 1], we can keep ascending, and thus dp[i] = dp[i - 1] + 1
//      3.2 array[i] <= array[i - 1], we are no longer ascending and need to start over, and thus dp[i] = 1
// dp[i] = {
//    dp[i - 1] + 1,   if array[i] > array[i - 1]
//    1,               otherwise
// }
public class LongestAscendingSubarray {
    public int longest(int[] array) {
        int maxLen = 0;
        int curLen = 0;
        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; ++i)  {
            if (array[i] > prev) {
                curLen++;
                maxLen = Math.max(maxLen, curLen);
            } else {
                curLen = 1;
            }
            prev = array[i];
        }
        return maxLen;
    }
}
