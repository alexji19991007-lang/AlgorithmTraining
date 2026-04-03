package Classs14DynamicProgramming3;

// Given an array containing only 0s and 1s, find the length of the longest subarray of consecutive 1s.

// Assumptions
// The given array is not null

// Examples
// {0, 1, 0, 1, 1, 1, 0}, the longest consecutive 1s is 3.

//  0  1  0  1  2  3  0
public class LongestConsecutive1s {
    public int longest(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int curLen = 0;
        int maxLen = 0;
        for (int value : array) {
            if (value == 1) {
                curLen++;
                maxLen = Math.max(maxLen, curLen);
            } else {
                curLen = 0;
            }
        }
        return maxLen;
    }
}
