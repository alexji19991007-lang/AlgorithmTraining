package Class10String2;

// Given an array containing only 0s and 1s and you can change at most k 0s to 1s,
// return the length of the longest subarray of consecutive 1s.

// Example:
// input = [1, 0, 0, 1, 1, 1, 0, 0]  k = 2
// Output: 6
// Explanation: we can flip the zeros at index 1 and 2 to 1, then we will have at most
//              6 consecutive 1s in total (from index 0 to index 5)

// Assumptions
// The given array is not null
public class LongestConsecutive1s {
    public int longestConsecutiveOnes(int[] nums, int k) {
        int slow = 0, fast = 0;
        int count = 0;
        int longest = 0;
        while (fast < nums.length) {
            if (nums[fast] == 1) {
                fast++;
                longest = Math.max(longest, fast - slow);
            } else if (count < k) {
                fast++;
                count++;
                longest = Math.max(longest, fast - slow);
            } else if (nums[slow] == 0) {
                slow++;
                count--;
            } else {
                slow++;
            }
        }
        return longest;
    }
}
