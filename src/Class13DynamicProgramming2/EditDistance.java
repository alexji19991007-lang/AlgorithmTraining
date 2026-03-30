package Class13DynamicProgramming2;

// Given two strings of alphanumeric characters, determine the minimum 
// number of Replace, Delete, and Insert operations needed to transform 
// one string into the other.

// Assumptions
// Both strings are not null

// Examples
// string one: “sigh”, string two : “asith”
// the edit distance between one and two is 2 (one insert “a” at front then replace “g” with “t”).

// Method 1: Recursion
// Time Complexity = O(3^(m + n)), m = length of string one, n = length of string two

// 1. What does dp[i][j] mean?
// dp[i][j] represents the minimum number of operations (insert, delete, replace)
// needed to transform the first i characters of string "one"
// into the first j characters of string "two".

// 2. What is the base case?
// dp[0][j] = j
// Transforming an empty string into the first j characters of "two"
// requires j insert operations.
//
// dp[i][0] = i
// Transforming the first i characters of "one" into an empty string
// requires i delete operations.

// 3. What is the recurrence relation?
// If one.charAt(i - 1) == two.charAt(j - 1):
//    dp[i][j] = dp[i - 1][j - 1]
//    (no operation needed since characters match)
// Else:
//    dp[i][j] = 1 + Math.min(
//          dp[i - 1][j - 1],  // replace
//          dp[i - 1][j],      // delete
//          dp[i][j - 1]       // insert
//    )
//
// Explanation:
// - Replace: change one[i-1] to two[j-1]
// - Delete: remove one[i-1]
// - Insert: add two[j-1] to "one"

public class EditDistance {
    // Time Complexity = O(m * n);
    // Space Complexity = O(m * n);
    public int editDistance(String one, String two) {
        if (one.isEmpty()) return two.length();
        if (two.isEmpty()) return one.length();
        int w1 = one.length();
        int w2 = two.length();
        int[][] dp = new int[w1 + 1][w2 + 1];
        for (int i = 0; i <= w1; ++i) {
            for (int j = 0; j <= w2; ++j) {
                if (i == 0) {
                    dp[0][j] = j;
                    continue;
                }
                if (j == 0) {
                    dp[i][0] = i;
                    continue;
                }
                if (one.charAt(i - 1) == two.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 左上角
                    int replace = dp[i - 1][j - 1];
                    // 上边
                    int delete = dp[i - 1][j];
                    // 左边
                    int insert = dp[i][j - 1];
                    dp[i][j] = 1 + Math.min(replace, Math.min(delete, insert));
                }
            }
        }
        return dp[w1][w2];
    }

    // Follow Up: What if we want to avoid using m * n extra space?
    // Use two arrays to solve this problem
    public static int minDistance(String one, String two) {
        if (one.isEmpty()) return two.length();
        if (two.isEmpty()) return one.length();
        // Always make sure one is the shorter string.
        if (one.length() > two.length()) {
            String temp = two;
            two = one;
            one = temp;
        }
        
        return -1;
    }
}
