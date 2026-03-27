package Class12DynamicProgramming1;

// Given a rope with positive integer-length n, how to cut the rope into m integer-length 
// parts with length p[0], p[1], ...,p[m-1], in order to get the maximal product of 
// p[0]*p[1]* ... *p[m-1]? m is determined by you and must be greater than 0 (at least 
// one cut must be made). Return the max product you can have.

// Assumptions
// n >= 2

// Examples
// n = 12, the max product is 3 * 3 * 3 * 3 = 81(cut the rope into 4 pieces with length of each is 3).

// 1. What does dp[i] mean?
//      dp[i] = The maximum product we can get by cutting a rope of length i
// 2. What is the base case?
//      dp[1] = 1
//      Because when the rope length is 1, the maximum product we can get is 1
// 3. What is the recurrence relations?
//      When we try to compute dp[i], we try every possible first cut position j (1 <= j <= i/2)
//      We cut the rope into two parts:
//          left part: length j
//          right part: length (i - j)
// For the left part (length j), we have two choices:
//    3.1 Do not cut it → product = j
//    3.2 Cut it further → product = dp[j]
// So the best for left part is: max(j, dp[j])
// For the right part (length i - j), we DO NOT look up dp[i - j], WE TAKE IT AS IT IS
// because we are enumerating all possibilities from left side already
// (this avoids duplicate counting)
// So for each j:
//
// candidate = max(j, dp[j]) * (i - j)
//
// We take the maximum over all j:
//
// dp[i] = max over all j in [1, i/2]:
//         max(j, dp[j]) * (i - j)
//
// 回家作业第一：为什么可以stop at i/2
public class MaxProductOfCuttingRope {
    public int maxProduct(int length) {
        int[] M = new int[length + 1];
        M[1] = 1;
        for (int i = 2; i < length + 1; ++i) {
            for (int j = 1; j <= i / 2; ++j) {
                M[i] = Math.max(M[i], Math.max(j, M[j]) * (i - j));
            }
        }
        return M[length];
    }
}
